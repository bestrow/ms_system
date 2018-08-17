package cn.libo.msproject.vo;

import cn.libo.msproject.entity.Msorder;

import java.io.Serializable;

public class MsorderVo implements Serializable {

    private Msorder msorder;

    private int stockcount;

    public Msorder getMsorder() {
        return msorder;
    }

    public void setMsorder(Msorder msorder) {
        this.msorder = msorder;
    }

    public int getStockcount() {
        return stockcount;
    }

    public void setStockcount(int stockcount) {
        this.stockcount = stockcount;
    }
}
