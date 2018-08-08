package cn.libo.msproject.entity;

import java.util.Date;

//秒杀商品表
public class Msproduct {
    private int id; //主键
    private int productid; //商品id
    private String producttitle; //商品标题
    private String productpicture; //商品图片
    private int originalprice; //原价格
    private int miaoshaprice; //秒杀价格
    private int merchantid; //商家id
    private Date applydate; //添加日期
    private Date auditdate; //审核日期
    private int auditstate; //审核状态 1.未审核 2.审核通过 3.审核不通过
    private Date starttime; //开始时间
    private Date endtime; //结束时间
    private String starttimestring;
    private String endtimestring;
    private int productcount; //秒杀商品数
    private int stockcount; //剩余库存数
    private String descrioption; //描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getProductpicture() {
        return productpicture;
    }

    public void setProductpicture(String productpicture) {
        this.productpicture = productpicture;
    }

    public int getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(int originalprice) {
        this.originalprice = originalprice;
    }

    public int getMiaoshaprice() {
        return miaoshaprice;
    }

    public void setMiaoshaprice(int miaoshaprice) {
        this.miaoshaprice = miaoshaprice;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    public int getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(int auditstate) {
        this.auditstate = auditstate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getProductcount() {
        return productcount;
    }

    public void setProductcount(int productcount) {
        this.productcount = productcount;
    }

    public int getStockcount() {
        return stockcount;
    }

    public void setStockcount(int stockcount) {
        this.stockcount = stockcount;
    }

    public String getDescrioption() {
        return descrioption;
    }

    public void setDescrioption(String descrioption) {
        this.descrioption = descrioption;
    }

    public String getStarttimestring() {
        return starttimestring;
    }

    public void setStarttimestring(String starttimestring) {
        this.starttimestring = starttimestring;
    }

    public String getEndtimestring() {
        return endtimestring;
    }

    public void setEndtimestring(String endtimestring) {
        this.endtimestring = endtimestring;
    }

    @Override
    public String toString() {
        return "Msproduct{" +
                "id=" + id +
                ", productid=" + productid +
                ", producttitle='" + producttitle + '\'' +
                ", productpicture='" + productpicture + '\'' +
                ", originalprice=" + originalprice +
                ", miaoshaprice=" + miaoshaprice +
                ", merchantid=" + merchantid +
                ", applydate=" + applydate +
                ", auditdate=" + auditdate +
                ", auditstate=" + auditstate +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", starttimestring='" + starttimestring + '\'' +
                ", endtimestring='" + endtimestring + '\'' +
                ", productcount=" + productcount +
                ", stockcount=" + stockcount +
                ", descrioption='" + descrioption + '\'' +
                '}';
    }
}
