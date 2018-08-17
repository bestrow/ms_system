package cn.libo.msproject.entity;

import java.io.Serializable;

//秒杀商家表
public class Msmerchant implements Serializable {

    private int id;// 主键
    private String merchantname;//商家姓名
    private String merchantshopname;// 商家店铺名称
    private String merchantaccount;//商家账号
    private String merchantpassword;// 商家密码
    private String merchantscope;// 商家经营范围

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getMerchantshopname() {
        return merchantshopname;
    }

    public void setMerchantshopname(String merchantshopname) {
        this.merchantshopname = merchantshopname;
    }

    public String getMerchantaccount() {
        return merchantaccount;
    }

    public void setMerchantaccount(String merchantaccount) {
        this.merchantaccount = merchantaccount;
    }

    public String getMerchantpassword() {
        return merchantpassword;
    }

    public void setMerchantpassword(String merchantpassword) {
        this.merchantpassword = merchantpassword;
    }

    public String getMerchantscope() {
        return merchantscope;
    }

    public void setMerchantscope(String merchantscope) {
        this.merchantscope = merchantscope;
    }

    @Override
    public String toString() {
        return "Msmerchant{" +
                "id=" + id +
                ", merchantname='" + merchantname + '\'' +
                ", merchantshopname='" + merchantshopname + '\'' +
                ", merchantaccount='" + merchantaccount + '\'' +
                ", merchantpassword='" + merchantpassword + '\'' +
                ", merchantscope='" + merchantscope + '\'' +
                '}';
    }
}
