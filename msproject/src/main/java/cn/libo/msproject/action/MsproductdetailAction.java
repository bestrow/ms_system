package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.service.MsproductdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("msproductdetailAction")
public class MsproductdetailAction {

    @Autowired
    private MsproductdetailService msproductdetailService;

    @RequestMapping("toinsertMsproductdetail")
    public String toinsertMsproductdetail(HttpServletRequest request, int productid, int merchantid) {
        request.setAttribute("productid", productid);
        request.setAttribute("merchantid", merchantid);
        return "msproductdetail/toinsertMsproductdetail";
    }


    @RequestMapping(value = "insertMsproductdetail", method = RequestMethod.POST)
    public String insertMsproductdetail(Msproductdetail msproductdetail) {
        msproductdetailService.insertMsproductdetail(msproductdetail);
        return "redirect:/msproductAction/listmsproduct";
    }

    @RequestMapping("queryMsproductdetailById")
    public String queryMsproductdetailById(HttpServletRequest request, int productid) {
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailById(productid);
        request.setAttribute("msproductdetail", msproductdetail);
        return "msproductdetail/view";
    }

    @RequestMapping("toupdateMsproductdetail")
    public String toupdateMsproductdetail(HttpServletRequest request, int productid) {
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailById(productid);
        request.setAttribute("msproductdetail", msproductdetail);
        return "msproductdetail/update";
    }

    @RequestMapping(value = "updateMsproductdetail", method = RequestMethod.POST)
    public String updateMsproductdetail(Msproductdetail msproductdetail) {
        msproductdetailService.updateMsproductdetail(msproductdetail);
        return "redirect:/msproductAction/listmsproduct";
    }

}
