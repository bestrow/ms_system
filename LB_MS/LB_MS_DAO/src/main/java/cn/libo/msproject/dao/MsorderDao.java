package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msorder;

import java.util.List;

public interface MsorderDao {

    public void insertMsOrder(Msorder msorder);

    public List<Msorder> queryMsorderByUserid(int userid);

    public List<Msorder> queryMsorderByMerchantid(int merchantid);

    public void updateMsorder(Msorder msorder);


}
