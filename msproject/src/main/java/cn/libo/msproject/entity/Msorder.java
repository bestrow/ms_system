package cn.libo.msproject.entity;

import java.util.Date;

//秒杀订单
public class Msorder {

    private int id; //主键
    private int productid; //秒杀商品id
    private int payamount; //支付金额
    private int userid; //用户id
    private int merchantid; //商家id
    private Date createtime; //创建时间
    private Date paytime; //支付时间
    private int paystatus; //支付状态 1.未支付 2.已支付 3.退款成功 4.用户发起退款申请 5.退款失败
    private String receivingadress; //收货人地址
    private String receivingphone; //收件人电话
    private String receivingname; //收货人名称
    private String tradeserialnumber; //交易流水号
    private int num; //数量
    private int paytype; //支付方式

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

    public int getPayamount() {
        return payamount;
    }

    public void setPayamount(int payamount) {
        this.payamount = payamount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public String getReceivingadress() {
        return receivingadress;
    }

    public void setReceivingadress(String receivingadress) {
        this.receivingadress = receivingadress;
    }

    public String getReceivingphone() {
        return receivingphone;
    }

    public void setReceivingphone(String receivingphone) {
        this.receivingphone = receivingphone;
    }

    public String getReceivingname() {
        return receivingname;
    }

    public void setReceivingname(String receivingname) {
        this.receivingname = receivingname;
    }

    public String getTradeserialnumber() {
        return tradeserialnumber;
    }

    public void setTradeserialnumber(String tradeserialnumber) {
        this.tradeserialnumber = tradeserialnumber;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    @Override
    public String toString() {
        return "Msorder{" +
                "id=" + id +
                ", productid=" + productid +
                ", payamount=" + payamount +
                ", userid=" + userid +
                ", merchantid=" + merchantid +
                ", createtime=" + createtime +
                ", paytime=" + paytime +
                ", paystatus=" + paystatus +
                ", receivingadress='" + receivingadress + '\'' +
                ", receivingphone='" + receivingphone + '\'' +
                ", receivingname='" + receivingname + '\'' +
                ", tradeserialnumber='" + tradeserialnumber + '\'' +
                ", num=" + num +
                ", paytype=" + paytype +
                '}';
    }
}

