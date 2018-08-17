package cn.libo.msproject.vo;

import cn.libo.msproject.entity.Msproduct;

import java.io.Serializable;

public class MsproductVo implements Serializable {

    private Msproduct msproduct;

    private int startoriginalprice;//商品原价查询范围-->开始
    private int endoriginalprice;//商品原价查询范围-->结束

    private int startmiaoshaprice;//秒杀价格查询范围-->开始
    private int endmiaoshaprice;//秒杀价格查询范围-->结束

    private String startapplydate;//申请时间查询范围-->开始
    private String endapplydate;//申请时间查询范围-->结束

    private String startauditdate;//审核时间查询范围-->开始
    private String endauditdate;//审核时间查询范围-->结束

    private String startstarttime;//秒杀开始时间查询范围-->开始
    private String endstarttime;//秒杀开始时间查询范围-->结束

    private String startendtime;//秒杀结束时间查询范围-->开始
    private String endendtime;//秒杀结束时间查询范围-->结束

    private int startproductcount;//秒杀商品数查询范围-->开始
    private int endproductcount;//秒杀商品数查询范围-->结束

    private int startstockcount;//库存数查询范围-->开始
    private int endstockcount;//库存数数查询范围-->结束

    public Msproduct getMsproduct() {
        return msproduct;
    }

    public void setMsproduct(Msproduct msproduct) {
        this.msproduct = msproduct;
    }

    public int getStartoriginalprice() {
        return startoriginalprice;
    }

    public void setStartoriginalprice(int startoriginalprice) {
        this.startoriginalprice = startoriginalprice;
    }

    public int getEndoriginalprice() {
        return endoriginalprice;
    }

    public void setEndoriginalprice(int endoriginalprice) {
        this.endoriginalprice = endoriginalprice;
    }

    public int getStartmiaoshaprice() {
        return startmiaoshaprice;
    }

    public void setStartmiaoshaprice(int startmiaoshaprice) {
        this.startmiaoshaprice = startmiaoshaprice;
    }

    public int getEndmiaoshaprice() {
        return endmiaoshaprice;
    }

    public void setEndmiaoshaprice(int endmiaoshaprice) {
        this.endmiaoshaprice = endmiaoshaprice;
    }

    public String getStartapplydate() {
        return startapplydate;
    }

    public void setStartapplydate(String startapplydate) {
        this.startapplydate = startapplydate;
    }

    public String getEndapplydate() {
        return endapplydate;
    }

    public void setEndapplydate(String endapplydate) {
        this.endapplydate = endapplydate;
    }

    public String getStartauditdate() {
        return startauditdate;
    }

    public void setStartauditdate(String startauditdate) {
        this.startauditdate = startauditdate;
    }

    public String getEndauditdate() {
        return endauditdate;
    }

    public void setEndauditdate(String endauditdate) {
        this.endauditdate = endauditdate;
    }

    public String getStartstarttime() {
        return startstarttime;
    }

    public void setStartstarttime(String startstarttime) {
        this.startstarttime = startstarttime;
    }

    public String getEndstarttime() {
        return endstarttime;
    }

    public void setEndstarttime(String endstarttime) {
        this.endstarttime = endstarttime;
    }

    public String getStartendtime() {
        return startendtime;
    }

    public void setStartendtime(String startendtime) {
        this.startendtime = startendtime;
    }

    public String getEndendtime() {
        return endendtime;
    }

    public void setEndendtime(String endendtime) {
        this.endendtime = endendtime;
    }

    public int getStartproductcount() {
        return startproductcount;
    }

    public void setStartproductcount(int startproductcount) {
        this.startproductcount = startproductcount;
    }

    public int getEndproductcount() {
        return endproductcount;
    }

    public void setEndproductcount(int endproductcount) {
        this.endproductcount = endproductcount;
    }

    public int getStartstockcount() {
        return startstockcount;
    }

    public void setStartstockcount(int startstockcount) {
        this.startstockcount = startstockcount;
    }

    public int getEndstockcount() {
        return endstockcount;
    }

    public void setEndstockcount(int endstockcount) {
        this.endstockcount = endstockcount;
    }
}
