package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.service.cache.MsproductCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MsproductCacheServiceImpl implements MsproductCacheService {

    @Autowired
    private MsproductService msproductService;

    @Cacheable(value = "MS_Cache", key = "'product:'+#id")
    public Msproduct queryMsproductById(int id) {
        return msproductService.queryMsproductById(id);
    }

    //TODO
    @CachePut(value = "MS_Cache", key = "'product:'+#id")
    public Msproduct updateMsproduct(Msproduct msproduct) {
        msproductService.updateMsproduct(msproduct);
        return msproductService.queryMsproductById(msproduct.getId());
    }
}
