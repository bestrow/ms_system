package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msmerchant;
import cn.libo.msproject.vo.MsmerchantVo;

import java.util.List;

public interface MsmerchantDao {

    public void insertMsmerchant(Msmerchant msmerchant);

    public Msmerchant queryMsmerchantById(int id);

    public void updateMsmerchant(Msmerchant msmerchant);

    public void deleteMsmerchantById(int id);

    public List<Msmerchant> queryMsmerchantByVo(MsmerchantVo msmerchantVo);
}
