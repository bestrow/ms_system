package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msproductdetail;

public interface MsproductdetailService {

    public void insertMsproductdetail(Msproductdetail msproductdetail);

    public Msproductdetail queryMsproductdetailById(int productid);

    public void updateMsproductdetail(Msproductdetail msproductdetail);


}
