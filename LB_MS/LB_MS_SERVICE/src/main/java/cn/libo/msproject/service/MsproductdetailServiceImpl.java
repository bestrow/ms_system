package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsproductdetailDao;
import cn.libo.msproject.entity.Msproductdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsproductdetailServiceImpl implements MsproductdetailService {

    @Autowired
    private MsproductdetailDao msproductdetailDao;

    public void insertMsproductdetail(Msproductdetail msproductdetail) {
        msproductdetailDao.insertMsproductdetail(msproductdetail);
    }

    public Msproductdetail queryMsproductdetailById(int productid) {
        return msproductdetailDao.queryMsproductdetailById(productid);
    }

    public void updateMsproductdetail(Msproductdetail msproductdetail) {
        msproductdetailDao.updateMsproductdetail(msproductdetail);
    }
}
