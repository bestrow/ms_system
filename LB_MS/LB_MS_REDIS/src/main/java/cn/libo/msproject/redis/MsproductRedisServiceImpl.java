package cn.libo.msproject.redis;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.service.cache.MsproductCacheService;
import cn.libo.msproject.service.redis.MsproductRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsproductRedisServiceImpl implements MsproductRedisService {

    @Autowired
    private MsproductCacheService msproductCacheService;

    @Autowired
    private RedisUtil redisUtil;

    public Msproduct queryMsproductById(int id) {
        Object result = redisUtil.get("product:" + id);
        Msproduct msproduct = null;
        if (result == null) {
            msproduct = msproductCacheService.queryMsproductById(id);
            redisUtil.set("product:" + id, msproduct);
        } else {
            System.out.println("come to redis queryMsproductById");
            msproduct = (Msproduct) result;
        }
        return msproduct;
    }

    public void updateMsproduct(Msproduct msproduct) {
        Msproduct msproductinfo = msproductCacheService.updateMsproduct(msproduct);
        int id = msproductinfo.getId();
        msproductinfo = msproductCacheService.queryMsproductById(id);
        redisUtil.set("product:" + id, msproductinfo);
    }
}
