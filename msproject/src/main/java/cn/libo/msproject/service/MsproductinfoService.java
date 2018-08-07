package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsproductinfoDao;
import cn.libo.msproject.entity.Msproductinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsproductinfoService {
    @Autowired
    private MsproductinfoDao msproductinfoDao;

    /**
     * 申请秒杀商品
     *
     * @param msproductinfo
     */
    public void insertMsproductinfo(Msproductinfo msproductinfo) {
        msproductinfoDao.insertMsproductinfo(msproductinfo);
    }
}
