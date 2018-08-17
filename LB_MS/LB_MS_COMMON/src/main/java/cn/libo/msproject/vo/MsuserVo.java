package cn.libo.msproject.vo;

import cn.libo.msproject.entity.Msuser;

import java.io.Serializable;

public class MsuserVo implements Serializable {

    private Msuser msuser;

    public Msuser getMsuser() {
        return msuser;
    }

    public void setMsuser(Msuser msuser) {
        this.msuser = msuser;
    }
}
