package cn.libo.msproject.dao;


import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.vo.MsproductVo;

import java.util.List;

public interface MsproductDao {

    public void applymsproduct(Msproduct msproduct);

    public List<Msproduct> listMsproduct(MsproductVo msproductVo);

    public Msproduct queryMsproductById(int id);

    public void deleteMsproductById(int id);

    public void updateMsproduct(Msproduct msproduct);

    public void updateMsproductState(MsproductVo msproductVo);
}
