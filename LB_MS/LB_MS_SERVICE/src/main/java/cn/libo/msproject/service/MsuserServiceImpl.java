package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsuserDao;
import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.vo.MsuserVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MsuserServiceImpl implements MsuserService {

    @Autowired
    private MsuserDao msuserDao;

    public void insertMsuser(Msuser msuser) {
        msuserDao.insertMsuser(msuser);
    }

    public Msuser queryMsuserById(int id) {
        return msuserDao.queryMsuserById(id);
    }

    public void updateMsuser(Msuser msuser) {
        msuserDao.updateMsuser(msuser);
    }

    public void deleteMsuserById(int id) {
        msuserDao.deleteMsuserById(id);
    }

    public List<Msuser> queryMsuserByVo(MsuserVo msuserVo) {
        return msuserDao.queryMsuserByVo(msuserVo);
    }

    public Msuser queryMsuserByuseraccount(String useraccount) {
        return msuserDao.queryMsuserByuseraccount(useraccount);
    }
}
