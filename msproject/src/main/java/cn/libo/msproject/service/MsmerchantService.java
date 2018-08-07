package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsmerchantDao;
import cn.libo.msproject.entity.Msmerchant;
import cn.libo.msproject.vo.MsmerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsmerchantService {

    @Autowired
    private MsmerchantDao msmerchantDao;

    public void insertMsmerchant(Msmerchant msmerchant) {
        msmerchantDao.insertMsmerchant(msmerchant);
    }

    public Msmerchant queryMsmerchantById(int id) {
        return msmerchantDao.queryMsmerchantById(id);
    }

    public void updateMsmerchant(Msmerchant msmerchant) {
        msmerchantDao.updateMsmerchant(msmerchant);
    }

    public void deleteMsmerchantById(int id) {
        msmerchantDao.deleteMsmerchantById(id);
    }

    public List<Msmerchant> queryMsmerchantByVo(MsmerchantVo msmerchantVo) {
        return msmerchantDao.queryMsmerchantByVo(msmerchantVo);
    }
}
