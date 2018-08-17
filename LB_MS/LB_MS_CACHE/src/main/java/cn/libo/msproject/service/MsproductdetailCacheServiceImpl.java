package cn.libo.msproject.service;

import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.service.cache.MsproductdetailCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MsproductdetailCacheServiceImpl implements MsproductdetailCacheService {

    @Autowired
    private MsproductdetailService msproductdetailService;

    @Cacheable(value = "MS_Cache", key = "'productdetail:'+#productid")
    public Msproductdetail queryMsproductdetailById(int productid) {
        return msproductdetailService.queryMsproductdetailById(productid);
    }
}
