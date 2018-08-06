package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsmerchantDao;
import cn.libo.msproject.entity.Msmerchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsmerchantService {

    @Autowired
    private MsmerchantDao msmerchantDao;

    public void insertMsmerchant(Msmerchant msmerchant) {
        msmerchantDao.insertMsmerchant(msmerchant);
    }

    public Msmerchant queryMsmerchantByid(int id) {
        return msmerchantDao.queryMsmerchantByid(id);
    }

    public void updateMsmerchant(Msmerchant msmerchant) {
        msmerchantDao.updateMsmerchant(msmerchant);
    }

    public void deleteMsmerchantByid(int id) {
        msmerchantDao.deleteMsmerchantByid(id);
    }
}
