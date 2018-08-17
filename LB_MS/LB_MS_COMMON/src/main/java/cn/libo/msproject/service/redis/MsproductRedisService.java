package cn.libo.msproject.service.redis;

import cn.libo.msproject.entity.Msproduct;

public interface MsproductRedisService {
    /**
     * 根据秒杀商品id查询秒杀商品
     *
     * @param id
     * @return
     */
    public Msproduct queryMsproductById(int id);

    /**
     * 更新商品信息
     *
     * @param id
     */
    public void updateMsproduct(Msproduct msproduct);
}
