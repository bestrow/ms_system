package cn.libo.msproject.action;

import cn.libo.msproject.entity.*;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.service.MsproductdetailService;
import cn.libo.msproject.service.pay.Alipay;
import cn.libo.msproject.service.pay.Bankpay;
import cn.libo.msproject.service.pay.WeChatpay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
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

    @RequestMapping(value = "topayorder", method = RequestMethod.POST)
    public String topayorder(HttpServletRequest request, int id, int num) {
        Msproduct msproduct = msproductService.queryMsproductById(id);
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailById(id);
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
    public String payorder(Msorder msorder) {
        msorder.setCreatetime(new Date());
        msorder.setPaystatus(1);
        String tradeserialnumber = UUID.randomUUID().toString();
        msorder.setTradeserialnumber(tradeserialnumber);
        msorderService.insertMsOrder(msorder);
        return "redirect:/pagehomeAction/tohome";
    }

    @RequestMapping("queryMsorderByUserid")
    public String queryMsorderByUserid(HttpServletRequest request) {
        String returnUrl = "order/listorder";
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        if (msuser != null) {
            List<Msorder> msorderList = msorderService.queryMsorderByUserid(msuser.getId());
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
    public String toPaywithMsorder(HttpServletRequest request, String tradeserialnumber, int payamount) {
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
    public String paywithMsorder(HttpServletRequest request, int paytype, String tradeserialnumber, int payamount) {
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
            msorder.setPaytype(paytype);
            msorder.setTradeserialnumber(tradeserialnumber);
            msorder.setPaystatus(2);
            msorderService.updateMsorder(msorder);
        }
        return "redirect:queryMsorderByUserid";
    }

    @RequestMapping("applyrefund")
    public String applyrefund(HttpServletRequest request, String tradeserialnumber) {
        String returnUrl = "redirect:queryMsorderByUserid";
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        if (msuser != null) {
            Msorder msorder = new Msorder();
            msorder.setPaystatus(4);
            msorder.setTradeserialnumber(tradeserialnumber);
            msorderService.updateMsorder(msorder);
        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msuser/tologin";
        }
        return returnUrl;
    }

    @RequestMapping("auditrefund")
    public String auditrefund(HttpServletRequest request, String tradeserialnumber, int paystatus, int payamount, int paytype) {
        String returnUrl = "redirect:queryMsorderByMerchantid";
        Msmerchant msmerchant = (Msmerchant) request.getSession().getAttribute("msmerchant");
        Msorder msorder = new Msorder();
        if (msmerchant != null) {
            if (paystatus == 3) {
                int paystatustemp = 2;
                if (paytype == 1) {
                    paystatustemp = alipay.refundwithorder(tradeserialnumber, payamount);
                } else if (paytype == 2) {
                    paystatustemp = weChatpay.refundwithorder(tradeserialnumber, payamount);
                } else if (paytype == 3) {
                    paystatustemp = bankpay.refundwithorder(tradeserialnumber, payamount);
                }
                if (paystatustemp == 1) {
                    msorder.setPaystatus(paystatus);
                    msorder.setTradeserialnumber(tradeserialnumber);
                    msorderService.updateMsorder(msorder);
                }
            } else if (paystatus == 5) {
                msorder.setPaystatus(paystatus);
                msorder.setTradeserialnumber(tradeserialnumber);
                msorderService.updateMsorder(msorder);
            }

        } else {
            request.setAttribute("error", "未登陆");
            returnUrl = "msmerchant/tologin";
        }
        return returnUrl;
    }
}
