package cn.libo.msproject.redis;

import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.service.cache.MsproductdetailCacheService;
import cn.libo.msproject.service.redis.MsproductdetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsproductdetailRedisServiceImpl implements MsproductdetailRedisService {

    @Autowired
    private MsproductdetailCacheService msproductdetailCacheService;

    @Autowired
    private RedisUtil redisUtil;

    public Msproductdetail queryMsproductdetailById(int productid) {
        Msproductdetail msproductdetail = null;
        Object result = redisUtil.get("detail:" + productid);
        if (result == null) {
            msproductdetail = msproductdetailCacheService.queryMsproductdetailById(productid);
            redisUtil.set("detail:" + productid, msproductdetail);
        } else {
            System.out.println("come to redis queryMsproductdetailById");
            msproductdetail = (Msproductdetail) result;
        }
        return msproductdetail;
    }
}
