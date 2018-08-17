package cn.libo.msproject.redis;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.service.redis.OrderRedisService;
import cn.libo.msproject.util.DateUtils;
import cn.libo.msproject.vo.MsorderVo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class OrderRedisServiceImpl implements OrderRedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public Map<String, Object> seckill(int userid, int productid, MsorderVo msorderVo) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        int stockcount = msorderVo.getStockcount();
        if (redisUtil.getKeyListSize(productid + "") > stockcount) {
            System.out.println("秒杀失败！");
            resultMap.put("success", false);
        }
        redisUtil.pushList(productid + "", userid + "");//TODO 怀疑会与其他地方插入的key 混淆
        System.out.println("秒杀成功！");
        String key = "userid:" + userid + "==productid:" + productid;
        String value = "";

        String createTimeString = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        String merchantid = msorderVo.getMsorder().getMerchantid() + "";
        String payamount = msorderVo.getMsorder().getPayamount() + "";
        String receivingadress = msorderVo.getMsorder().getReceivingadress();
        String receivingname = msorderVo.getMsorder().getReceivingname();
        String receivingphone = msorderVo.getMsorder().getReceivingphone();
        String stockcountnum = stockcount + "";
        String tradeserialnumber = createTimeString + UUID.randomUUID();
        String paystatus = "1";
        value += paystatus + "==" + tradeserialnumber + "==" + createTimeString + "==" + merchantid + "==" + payamount + "==" +
                receivingadress + "==" + receivingname + "==" + receivingphone + "==" + stockcountnum;
        redisUtil.set(key, value);
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("createTime", createTimeString);
        dataMap.put("merchantid", merchantid);
        dataMap.put("payamount", payamount);
        dataMap.put("receivingadress", receivingadress);
        dataMap.put("receivingname", receivingname);
        dataMap.put("receivingphone", receivingphone);
        dataMap.put("stockcountnum", stockcountnum);
        dataMap.put("tradeserialnumber", tradeserialnumber);
        dataMap.put("paystatus", paystatus);
        dataMap.put("productid", productid + "");
        dataMap.put("userid", userid + "");

        amqpTemplate.convertAndSend("ms_exchange", "orderinfo", dataMap);

        resultMap.put("success", true);
        resultMap.put("dataMap", dataMap);
        return resultMap;
    }

    public boolean payorder(int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        String key = "userid:" + userid + "==productid:" + productid;
        String value = (String) redisUtil.get(key);
        String[] splitvalues = value.split("==");
        splitvalues[0] = "2";
        value = "";
        for (String temp : splitvalues) {
            value += temp + "==";
        }
        boolean issuccess = redisUtil.set(key, value);

        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("tradeserialnumber", tradeserialnumber);
        dataMap.put("paystatus", "2");
        String paytimeString = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        dataMap.put("paytimeString", paytimeString);
        dataMap.put("paytype", paytype + "");
        dataMap.put("flag", "pay");

        amqpTemplate.convertAndSend("ms_exchange", "payinfo", dataMap);

        return issuccess;
    }

    public List<Msorder> queryMsorderByUserid(int userid) {
        List<Msorder> msorderList = new ArrayList<Msorder>();
        Set<String> keys = redisUtil.getkeys("userid:" + userid);
        for (String key : keys) {
            String[] prusers = key.split("==");
            String productid = prusers[1].split(":")[1];
            String useridstring = prusers[0].split(":")[1];
            String value = (String) redisUtil.get(key);
            String[] valuearray = value.split("==");

            String paystatus = valuearray[0];
            String tradeserialnumber = valuearray[1];
            String createTimeString = valuearray[2];
            String merchantid = valuearray[3];
            String payamount = valuearray[4];
            String receivingadress = valuearray[5];
            String receivingname = valuearray[6];
            String receivingphone = valuearray[7];
            String stockcountnum = valuearray[8];

            Msorder msorder = new Msorder();
            msorder.setCreatetime(DateUtils.transferdate(createTimeString, "yyyy-MM-dd HH:mm:ss"));
            msorder.setMerchantid(Integer.valueOf(merchantid));
            msorder.setPayamount(Integer.valueOf(payamount));
            msorder.setReceivingadress(receivingadress);
            msorder.setReceivingname(receivingname);
            msorder.setProductid(Integer.valueOf(productid));
            msorder.setReceivingphone(receivingphone);
            msorder.setTradeserialnumber(tradeserialnumber);
            msorder.setUserid(userid);
            msorder.setPaystatus(Integer.valueOf(paystatus));
            msorder.setNum(1);

            msorderList.add(msorder);
        }
        return msorderList;
    }

    public void updatePaystatusByTradeserialnumber(String flag, int userid, int paystatusparam, String tradeserialnumberparam, int paytype) {
        List<Msorder> msorderList = new ArrayList<Msorder>();
        Set<String> keys = redisUtil.getkeys("userid:" + userid);
        for (String key : keys) {
            String value = (String) redisUtil.get(key);
            String[] valuearray = value.split("==");

            String tradeserialnumber = valuearray[1];
            if (!tradeserialnumber.equals(tradeserialnumberparam)) {
                continue;
            }
            String createTimeString = valuearray[2];
            String merchantid = valuearray[3];
            String payamount = valuearray[4];
            String receivingadress = valuearray[5];
            String receivingname = valuearray[6];
            String receivingphone = valuearray[7];
            String stockcountnum = valuearray[8];
            String valuemp = paystatusparam + "==" + tradeserialnumber + "==" + createTimeString + "==" + merchantid + "==" + payamount + "==" +
                    receivingadress + "==" + receivingname + "==" + receivingphone + "==" + stockcountnum;
            redisUtil.set(key, valuemp);
            //发送异步消息
            Map<String, String> dataMap = new HashMap<String, String>();
            if ("update".equals(flag)) {
                dataMap.put("tradeserialnumber", tradeserialnumber);
                dataMap.put("paystatus", paystatusparam + "");
                dataMap.put("flag", "update");
            } else if ("refund".equals(flag)) {
                dataMap.put("tradeserialnumber", tradeserialnumber);
                dataMap.put("paystatus", paystatusparam + "");
                dataMap.put("paytype", paytype + "");
                dataMap.put("payamount", payamount);
                dataMap.put("flag", "refund");
            }
            amqpTemplate.convertAndSend("ms_exchange", "payinfo", dataMap);
        }
    }

    public long visitTimes(int userid) {
        redisUtil.set(userid + "##", System.currentTimeMillis()+"");
        return redisUtil.incr(userid + "==", 1);
    }

    public long getUserVisitTimes(int userid) {
        long times = Long.valueOf(redisUtil.get(userid + "##") == null?"1":redisUtil.get(userid + "##")+"");
        return times;
    }
}
