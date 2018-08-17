package cn.libo.msproject.service.impl;

import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.pay.Alipay;
import cn.libo.msproject.service.pay.Bankpay;
import cn.libo.msproject.service.pay.WeChatpay;
import cn.libo.msproject.util.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Map;

public class PayinfoService implements MessageListener {

    @Autowired
    private MsorderService msorderService;

    @Autowired
    private Alipay alipay;

    @Autowired
    private WeChatpay weChatpay;

    @Autowired
    private Bankpay bankpay;

    public void onMessage(Message message) {
        try {
            byte[] messagebyte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messagebyte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String flag = dataMap.get("flag");
            if ("update".equals(flag)) {
                String tradeserialnumber = dataMap.get("tradeserialnumber");
                int paystatus = Integer.valueOf(dataMap.get("paystatus"));
                msorderService.updatePaystatusByTradeserialnumber(Integer.valueOf(paystatus), tradeserialnumber);

            } else if ("refund".equals(flag)) {
                String tradeserialnumber = dataMap.get("tradeserialnumber");
                int paystatus = Integer.valueOf(dataMap.get("paystatus"));
                int paytype = Integer.valueOf(dataMap.get("paytype"));
                int payamount = Integer.valueOf(dataMap.get("payamount"));
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
                        msorderService.updatePaystatusByTradeserialnumber(paystatus, tradeserialnumber);
                    }
                } else if (paystatus == 5) {
                    msorderService.updatePaystatusByTradeserialnumber(paystatus, tradeserialnumber);

                }

            } else {
                String tradeserialnumber = dataMap.get("tradeserialnumber");
                int paystatus = Integer.valueOf(dataMap.get("paystatus"));
                Date paytime = DateUtils.transferdate(dataMap.get("paytimeString"), "yyyy-MM-dd HH:mm:ss");
                int paytype = Integer.valueOf(dataMap.get("paytype"));
                msorderService.updateMsorderByTrnumber(paystatus, tradeserialnumber, paytype, paytime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("消息消费者 = " + message.toString());
    }
}
