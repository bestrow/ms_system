package cn.libo.msproject.service.redis;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.vo.MsorderVo;

import java.util.List;
import java.util.Map;

public interface OrderRedisService {

    public Map<String, Object> seckill(int userid, int productid, MsorderVo msorderVo);

    public boolean payorder(int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount);

    public List<Msorder> queryMsorderByUserid(int userid);

    public void updatePaystatusByTradeserialnumber(String flag, int userid, int paystatusparam, String tradeserialnumberparam, int paytype);

    public long visitTimes(int userid);

    public long getUserVisitTimes(int userid);

}
