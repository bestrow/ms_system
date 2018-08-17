package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msorder;

import java.util.List;

public interface MsorderService {

    public void insertMsOrder(Msorder msorder);

    public List<Msorder> queryMsorderByUserid(int userid);

    public List<Msorder> queryMsorderByMerchantid(int merchantid);

    public void updateMsorder(Msorder msorder);
}
