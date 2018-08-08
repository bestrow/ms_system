package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.vo.MsproductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("msproductAction")
public class MsproductAction {

    @Autowired
    private MsproductService msproductService;

    @RequestMapping("toApplymsproduct")
    public String toApplymsproduct() {
        return "msproduct/applymsproduct";
    }

    @RequestMapping(value = "applymsproduct", method = RequestMethod.POST)
    public String applymsproduct(Msproduct msproduct) {
        msproductService.applymsproduct(msproduct);
        System.out.println(msproduct);
        return "redirect:listmsproduct";
    }

    @RequestMapping("listmsproduct")
    public String listMsproduct(HttpServletRequest request, MsproductVo msproductVo) {
        List<Msproduct> msproductList = msproductService.listMsproduct(msproductVo);
        request.setAttribute("msproductList", msproductList);
        return "msproduct/list";
    }

    @RequestMapping("queryMsproductById")
    public String queryMsproductById(HttpServletRequest request, int id) {
        Msproduct msproduct = msproductService.queryMsproductById(id);
        request.setAttribute("msproduct", msproduct);
        return "msproduct/view";

    }

    @RequestMapping("deleteMsproductById")
    public String deleteMsproductById(HttpServletRequest request, int id) {
        msproductService.deleteMsproductById(id);
        return "redirect:listmsproduct";
    }

    @RequestMapping("toupdateMsproduct")
    public String toupdateMsproduct(HttpServletRequest request, int id) {
        Msproduct msproduct = msproductService.queryMsproductById(id);

        Date starttime = msproduct.getStarttime();
        Date endtime = msproduct.getEndtime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        msproduct.setStarttimestring(dateFormat.format(starttime));
        msproduct.setEndtimestring(dateFormat.format(endtime));

        request.setAttribute("msproduct", msproduct);
        return "msproduct/update";
    }

    @RequestMapping(value = "updateMsproduct", method = RequestMethod.POST)
    public String updateMsproduct(Msproduct msproduct) {
        msproductService.updateMsproduct(msproduct);
        return "redirect:listmsproduct";
    }

    @RequestMapping("toupdateMsproductState")
    public String toupdateMsproductState(HttpServletRequest request, int id) {
        Msproduct msproduct = msproductService.queryMsproductById(id);

        Date starttime = msproduct.getStarttime();
        Date endtime = msproduct.getEndtime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        msproduct.setStarttimestring(dateFormat.format(starttime));
        msproduct.setEndtimestring(dateFormat.format(endtime));

        request.setAttribute("msproduct", msproduct);
        return "msproduct/auditmsproduct";
    }

    @RequestMapping(value = "updateMsproductState", method = RequestMethod.POST)
    public String updateMsproductState(int id, int state) {
        msproductService.updateMsproductState(id, state);
        return "redirect:listmsproduct";
    }

}
