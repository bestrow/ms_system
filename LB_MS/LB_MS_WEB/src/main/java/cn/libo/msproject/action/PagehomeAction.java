package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.service.MsproductdetailService;
import cn.libo.msproject.vo.MsproductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {
    @Autowired
    private MsproductService msproductService;

    @Autowired
    private MsproductdetailService msproductdetailService;

    @RequestMapping("tohome")
    public String tohome(HttpServletRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        Msproduct msproduct = new Msproduct();
        msproduct.setAuditstate(2);

        MsproductVo msproductVo = new MsproductVo();
        msproductVo.setMsproduct(msproduct);
        msproductVo.setStartendtime(dateString);

        List<Msproduct> msproductList = msproductService.listMsproduct(msproductVo);
        request.setAttribute("msproductList", msproductList);
        return "homepage/homepage";
    }

    @RequestMapping("viewproductdetail")
    public String viewproductdetail(HttpServletRequest request,int id){
        Msproduct msproduct = msproductService.queryMsproductById(id);
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailById(id);
        request.setAttribute("msproduct",msproduct);
        request.setAttribute("msproductdetail",msproductdetail);
        return "order/selldetail";
    }
}
