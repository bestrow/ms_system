package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msorder;

import java.util.Date;
import java.util.List;

public interface MsorderService {

    public void insertMsOrder(Msorder msorder);

    public List<Msorder> queryMsorderByUserid(int userid);

    public List<Msorder> queryMsorderByMerchantid(int merchantid);

    public void updateMsorder(Msorder msorder);

    public void updateMsorderByTrnumber(int paystatus, String tradeserialnumber, int paytype, Date paytime);

    public void updatePaystatusByTradeserialnumber(int paystatus, String tradeserialnumber);

    public List<Msorder> listMsorder();

    public void updateflagById(int orderflag, int id);
}
