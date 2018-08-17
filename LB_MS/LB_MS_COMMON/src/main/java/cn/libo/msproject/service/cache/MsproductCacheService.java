package cn.libo.msproject.service.cache;

import cn.libo.msproject.entity.Msproduct;

public interface MsproductCacheService {
    /**
     * 根据秒杀商品id查询秒杀商品
     *
     * @param id
     * @return
     */
    public Msproduct queryMsproductById(int id);

    public Msproduct updateMsproduct(Msproduct msproduct);
}
