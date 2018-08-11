package cn.libo.msproject.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WeChatpay implements MsorderToPay {

    @Override
    public int paywithorder(String tradeserialnumber, int payamount) {
        System.out.println("微信支付成功！");
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialnumber, int payamount) {
        System.out.println("微信退款成功！");
        return 1;
    }
}
