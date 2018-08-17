package cn.libo.msproject.service.impl;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.util.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class OrderinfoService implements MessageListener {

    @Autowired
    private MsorderService msorderService;

    public void onMessage(Message message) {
        try {
            byte[] messagebyte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messagebyte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String createTime = dataMap.get("createTime");
            String merchantid = dataMap.get("merchantid");
            String payamount = dataMap.get("payamount");
            String receivingadress = dataMap.get("receivingadress");
            String receivingname = dataMap.get("receivingname");
            String receivingphone = dataMap.get("receivingphone");
            String stockcountnum = dataMap.get("stockcountnum");
            String tradeserialnumber = dataMap.get("tradeserialnumber");
            String paystatus = dataMap.get("paystatus");
            String productid = dataMap.get("productid");
            String userid = dataMap.get("userid");

            Msorder msorder = new Msorder();
            msorder.setUserid(Integer.valueOf(userid));
            msorder.setProductid(Integer.valueOf(productid));
            msorder.setCreatetime(DateUtils.transferdate(createTime, "yyyy-MM-dd HH:mm:ss"));
            msorder.setTradeserialnumber(tradeserialnumber);
            msorder.setMerchantid(Integer.valueOf(merchantid));
            msorder.setNum(1);
            msorder.setPayamount(Integer.valueOf(payamount));
            msorder.setPaystatus(Integer.valueOf(paystatus));
            msorder.setReceivingadress(receivingadress);
            msorder.setReceivingname(receivingname);
            msorder.setReceivingphone(receivingphone);


            msorderService.insertMsOrder(msorder);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消息消费者 = " + message.toString());
    }
}
