package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsorderDao;
import cn.libo.msproject.entity.Msorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsorderService {

    @Autowired
    private MsorderDao msorderDao;

    public void insertMsOrder(Msorder msorder) {
        msorderDao.insertMsOrder(msorder);
    }

    public List<Msorder> queryMsorderByUserid(int userid) {
        return msorderDao.queryMsorderByUserid(userid);
    }

    public List<Msorder> queryMsorderByMerchantid(int merchantid){
        return msorderDao.queryMsorderByMerchantid(merchantid);
    }

    public void updateMsorder(Msorder msorder) {
        msorderDao.updateMsorder(msorder);
    }
}
