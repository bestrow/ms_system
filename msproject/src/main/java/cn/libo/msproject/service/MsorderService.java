package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsorderDao;
import cn.libo.msproject.entity.Msorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsorderService {

    @Autowired
    private MsorderDao msorderDao;

    public void insertMsOrder(Msorder msorder){
        msorderDao.insertMsOrder(msorder);
    }
}
