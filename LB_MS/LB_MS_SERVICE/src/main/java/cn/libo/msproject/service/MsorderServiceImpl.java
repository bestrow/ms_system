package cn.libo.msproject.service;

import cn.libo.msproject.dao.MsorderDao;
import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.vo.MsorderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MsorderServiceImpl implements MsorderService {

    @Autowired
    private MsorderDao msorderDao;

    public void insertMsOrder(Msorder msorder) {
        msorderDao.insertMsOrder(msorder);
    }

    public List<Msorder> queryMsorderByUserid(int userid) {
        return msorderDao.queryMsorderByUserid(userid);
    }

    public List<Msorder> queryMsorderByMerchantid(int merchantid) {
        return msorderDao.queryMsorderByMerchantid(merchantid);
    }

    public void updateMsorder(Msorder msorder) {
        msorderDao.updateMsorder(msorder);
    }

    public void updateMsorderByTrnumber(int paystatus, String tradeserialnumber, int paytype, Date paytime) {
        MsorderVo msorderVo = new MsorderVo();
        Msorder msorder = new Msorder();
        msorder.setPaystatus(paystatus);
        msorder.setTradeserialnumber(tradeserialnumber);
        msorder.setPaytype(paytype);
        msorder.setPaytime(paytime);
        msorderVo.setMsorder(msorder);
        msorderDao.updateMsorderByTrnumber(msorderVo);
    }

    public void updatePaystatusByTradeserialnumber(int paystatus, String tradeserialnumber) {
        Msorder msorder = new Msorder();
        msorder.setTradeserialnumber(tradeserialnumber);
        msorder.setPaytype(paystatus);
        msorderDao.updatePaystatusByTradeserialnumber(msorder);
    }

    public List<Msorder> listMsorder() {
        return msorderDao.listMsorder();
    }

    public void updateflagById(int orderflag, int id) {
        Msorder msorder = new Msorder();
        msorder.setId(id);
        msorder.setOrderflag(orderflag);
        msorderDao.updateflagById(msorder);
    }
}
