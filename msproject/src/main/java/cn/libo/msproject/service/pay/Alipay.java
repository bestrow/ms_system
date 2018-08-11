package cn.libo.msproject.service.pay;

import org.springframework.stereotype.Service;

@Service
public class Alipay implements MsorderToPay {

    @Override
    public int paywithorder(String tradeserialnumber, int payamount) {
        System.out.println("支付宝支付成功！");
        return 1;
    }

    @Override
    public int refundwithorder(String tradeserialnumber, int payamount) {
        System.out.println("支付宝退款成功！");
        return 1;
    }
}
