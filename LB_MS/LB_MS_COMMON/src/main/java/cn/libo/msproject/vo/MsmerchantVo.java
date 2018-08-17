package cn.libo.msproject.vo;

import cn.libo.msproject.entity.Msmerchant;

import java.io.Serializable;

public class MsmerchantVo implements Serializable {

    private Msmerchant msmerchant;

    public Msmerchant getMsmerchant() {
        return msmerchant;
    }

    public void setMsmerchant(Msmerchant msmerchant) {
        this.msmerchant = msmerchant;
    }
}
