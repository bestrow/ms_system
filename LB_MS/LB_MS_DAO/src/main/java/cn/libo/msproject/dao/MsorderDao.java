package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.vo.MsorderVo;

import java.util.List;

public interface MsorderDao {

    public void insertMsOrder(Msorder msorder);

    public List<Msorder> queryMsorderByUserid(int userid);

    public List<Msorder> queryMsorderByMerchantid(int merchantid);

    public void updateMsorder(Msorder msorder);

    public void updateMsorderByTrnumber(MsorderVo msorderVo);

    public void updatePaystatusByTradeserialnumber(Msorder msorder);

    public List<Msorder> listMsorder();

    public void updateflagById(Msorder msorder);
}
