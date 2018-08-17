package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.vo.MsproductVo;

import java.util.List;

public interface MsproductService {

    /**
     * 申请秒杀商品
     *
     * @param msproduct
     */
    public void applymsproduct(Msproduct msproduct);

    /**
     * 秒杀商品列表查询
     *
     * @param msproductVo
     * @return
     */
    public List<Msproduct> listMsproduct(MsproductVo msproductVo);

    /**
     * 根据秒杀商品id查询秒杀商品
     *
     * @param id
     * @return
     */
    public Msproduct queryMsproductById(int id);

    /**
     * 根据秒杀商品id删除秒杀商品
     *
     * @param id
     */
    public void deleteMsproductById(int id);

    /**
     * 修改秒杀商品信息
     *
     * @param msproduct
     */
    public void updateMsproduct(Msproduct msproduct);

    /**
     * 修改秒杀商品的审核状态
     *
     * @param id
     * @param state
     */
    public void updateMsproductState(int id, int state);
}
