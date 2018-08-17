package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsproductDao;
import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.vo.MsproductVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MsproductServiceImpl implements MsproductService {

    @Autowired
    private MsproductDao msproductDao;

    /**
     * 申请秒杀商品
     *
     * @param msproduct
     */
    public void applymsproduct(Msproduct msproduct) {
        String starttime = msproduct.getStarttimestring();
        String endtime = msproduct.getEndtimestring();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date starttimedate = dateFormat.parse(starttime);
            msproduct.setStarttime(starttimedate);

            Date endtimedate = dateFormat.parse(endtime);
            msproduct.setEndtime(endtimedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        msproduct.setApplydate(new Date());
        msproduct.setAuditstate(1);
        msproductDao.applymsproduct(msproduct);
    }

    /**
     * 秒杀商品列表查询
     *
     * @param msproductVo
     * @return
     */
    public List<Msproduct> listMsproduct(MsproductVo msproductVo) {
        return msproductDao.listMsproduct(msproductVo);
    }

    /**
     * 根据秒杀商品id查询秒杀商品
     *
     * @param id
     * @return
     */
    public Msproduct queryMsproductById(int id) {
        return msproductDao.queryMsproductById(id);
    }

    /**
     * 根据秒杀商品id删除秒杀商品
     *
     * @param id
     */
    
    public void deleteMsproductById(int id) {
        msproductDao.deleteMsproductById(id);
    }

    /**
     * 修改秒杀商品信息
     *
     * @param msproduct
     */
    public void updateMsproduct(Msproduct msproduct) {
        String starttime = msproduct.getStarttimestring();
        String endtime = msproduct.getEndtimestring();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date starttimedate = dateFormat.parse(starttime);
            msproduct.setStarttime(starttimedate);

            Date endtimedate = dateFormat.parse(endtime);
            msproduct.setEndtime(endtimedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        msproductDao.updateMsproduct(msproduct);
    }

    /**
     * 修改秒杀商品的审核状态
     *
     * @param id
     * @param state
     */
    public void updateMsproductState(int id, int state) {
        Msproduct msproduct = new Msproduct();
        msproduct.setId(id);
        msproduct.setAuditstate(state);
        msproduct.setAuditdate(new Date());
        MsproductVo msproductVo = new MsproductVo();
        msproductVo.setMsproduct(msproduct);
        msproductDao.updateMsproductState(msproductVo);
    }
}
