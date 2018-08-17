package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msproductdetail;

public interface MsproductdetailDao {

    public void insertMsproductdetail(Msproductdetail msproductdetail);

    public Msproductdetail queryMsproductdetailById(int productid);

    public void updateMsproductdetail(Msproductdetail msproductdetail);

}
