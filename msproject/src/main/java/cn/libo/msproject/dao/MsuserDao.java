package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.vo.MsuserVo;

import java.util.List;

public interface MsuserDao {

    public void insertMsuser(Msuser msuser);

    public Msuser queryMsuserById(int id);

    public void updateMsuser(Msuser msuser);

    public void deleteMsuserById(int id);

    public List<Msuser> queryMsuserByVo(MsuserVo msuserVo);
}
