package cn.libo.msproject.action;

import cn.libo.msproject.entity.*;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.service.MsproductdetailService;
import cn.libo.msproject.service.pay.Alipay;
import cn.libo.msproject.service.pay.Bankpay;
import cn.libo.msproject.service.pay.WeChatpay;
import cn.libo.msproject.service.redis.MsproductRedisService;
import cn.libo.msproject.service.redis.MsproductdetailRedisService;
import cn.libo.msproject.service.redis.OrderRedisService;
import cn.libo.msproject.vo.MsorderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("msorderAction")
public class MsorderAction {

    @Autowired
    private MsorderService msorderService;

    @Autowired
    private MsproductService msproductService;

    @Autowired
    private MsproductdetailService msproductdetailService;

    @Autowired
    private Alipay alipay;

    @Autowired
    private WeChatpay weChatpay;

    @Autowired
    private Bankpay bankpay;

    @Autowired
    private MsproductRedisService msproductRedisService;

    @Autowired
    private MsproductdetailRedisService msproductdetailRedisService;

    @Autowired
    private OrderRedisService orderRedisService;

    @RequestMapping(value = "topayorder", method = RequestMethod.POST)
    public String topayorder(HttpServletRequest request, int id, int num) {
        Msproduct msproduct = msproductRedisService.queryMsproductById(id);
        Msproductdetail msproductdetail = msproductdetailRedisService.queryMsproductdetailById(id);
        request.setAttribute("msproductdetail", msproductdetail);
        request.setAttribute("msproduct", msproduct);
        request.setAttribute("productnum", num);
        int payamount = msproduct.getMiaoshaprice() * num;
        request.setAttribute("payamount", payamount);
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        request.setAttribute("userid", msuser.getId());
        return "order/payorder";
    }

    @RequestMapping(value = "payorder", method = RequestMethod.POST)
    public String payorder(HttpServletRequest request, Msorder msorder) {
        String returnUrl = "redirect:/pagehomeAction/tohome";
        MsorderVo msorderVo = new MsorderVo();
        msorderVo.setMsorder(msorder);
        msorderVo.setStockcount(Integer.valueOf(request.getParameter("stockcount")));
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        if (msuser != null) {
            long time = orderRedisService.getUserVisitTimes(msuser.getId());
            long currentTime = System.currentTimeMillis();
            long shijiancha = currentTime - time;
            long senconds = shijiancha / 1000;
            long times = orderRedisService.visitTimes(msuser.getId());
            if (times / senconds > 50) {
                System.out.println("非法访问！");
                return returnUrl;
            }
            Map<String, Object> resultMap = orderRedisService.seckill(msuser.getId(), msorder.getProductid(), msorderVo);
            boolean issuccess = (Boolean) resultMap.get("success");
            if (issuccess) {
                System.out.println("秒杀成功！");
                Map<String, String> dataMap = (Map<String, String>) resultMap.get("dataMap");
                String merchantid = dataMap.get("merchantid");
                String payamount = dataMap.get("payamount");
                String tradeserialnumber = dataMap.get("tradeserialnumber");
                String productid = dataMap.get("productid");
                String userid = dataMap.get("userid");

                returnUrl = "redirect:topaywithMsorder?userid=" + userid + "&&productid=" + productid + "&&tradeserialnumber=" + tradeserialnumber
                        + "&&payamount=" + payamount + "&&merchantid=" + merchantid;
            } else {
                System.out.println("秒杀失败！");
            }
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msuser/tologin";
        }
        return returnUrl;
    }

    @RequestMapping("queryMsorderByUserid")
    public String queryMsorderByUserid(HttpServletRequest request) {
        String returnUrl = "order/listorder";
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        if (msuser != null) {
            List<Msorder> msorderList = orderRedisService.queryMsorderByUserid(msuser.getId());
            request.setAttribute("msorderList", msorderList);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msuser/tologin";
        }
        return returnUrl;
    }

    @RequestMapping("queryMsorderByMerchantid")
    public String queryMsorderByMerchantid(HttpServletRequest request) {
        String returnUrl = "order/listorderwithmerchant";
        Msmerchant msmerchant = (Msmerchant) request.getSession().getAttribute("msmerchant");
        if (msmerchant != null) {
            List<Msorder> msorderList = msorderService.queryMsorderByMerchantid(msmerchant.getId());
            request.setAttribute("msorderList", msorderList);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msmerchant/tologin";
        }
        return returnUrl;
    }

    /**
     * 跳转到支付页面
     *
     * @return
     */
    @RequestMapping("topaywithMsorder")
    public String toPaywithMsorder(HttpServletRequest request, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        request.setAttribute("userid", userid);
        request.setAttribute("productid", productid);
        request.setAttribute("merchantid", merchantid);
        request.setAttribute("tradeserialnumber", tradeserialnumber);
        request.setAttribute("payamount", payamount);
        return "order/payreal";
    }

    /**
     * @param request
     * @param paytype           1.代表支付宝 2.代表微信 3.代表银联
     * @param tradeserialnumber
     * @param payamount
     * @return
     */
    @RequestMapping(value = "paywithMsorder", method = RequestMethod.POST)
    public String paywithMsorder(HttpServletRequest request, int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        Msorder msorder = new Msorder();
        int paystatus = 2;

        if (paytype == 1) {
            paystatus = alipay.paywithorder(tradeserialnumber, payamount);
        } else if (paytype == 2) {
            paystatus = weChatpay.paywithorder(tradeserialnumber, payamount);
        } else if (paytype == 3) {
            paystatus = bankpay.paywithorder(tradeserialnumber, payamount);
        }

        if (paystatus == 1) {
            boolean issuccess = orderRedisService.payorder(paytype, userid, productid, merchantid, tradeserialnumber, payamount);
            if (issuccess) {
                System.out.println("支付成功!");
            } else {
                System.out.println("保存失败!");
            }
        }
        return "redirect:queryMsorderByUserid";
    }

    @RequestMapping("applyrefund")
    public String applyrefund(HttpServletRequest request, String tradeserialnumber) {
        String returnUrl = "redirect:queryMsorderByUserid";
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        if (msuser != null) {
            orderRedisService.updatePaystatusByTradeserialnumber("update", msuser.getId(), 4, tradeserialnumber, -1);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msuser/tologin";
        }
        return returnUrl;
    }

    @RequestMapping("auditrefund")
    public String auditrefund(HttpServletRequest request, String tradeserialnumber, int userid, int paystatus, int payamount, int paytype) {
        String returnUrl = "redirect:queryMsorderByMerchantid";
        Msmerchant msmerchant = (Msmerchant) request.getSession().getAttribute("msmerchant");
        Msorder msorder = new Msorder();
        if (msmerchant != null) {
            orderRedisService.updatePaystatusByTradeserialnumber("refund", userid, paystatus, tradeserialnumber, paytype);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msmerchant/tologin";
        }
        return returnUrl;
    }
}
