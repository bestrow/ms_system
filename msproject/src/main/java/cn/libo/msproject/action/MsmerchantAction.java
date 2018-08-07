package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msmerchant;
import cn.libo.msproject.service.MsmerchantService;
import cn.libo.msproject.vo.MsmerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("msmerchantAction")
public class MsmerchantAction {

    @Autowired
    private MsmerchantService msmerchantService;

    @RequestMapping("toadd")
    public String toadd() {
        return "msmerchant/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Msmerchant msmerchant) {
        msmerchantService.insertMsmerchant(msmerchant);
        System.out.println(msmerchant);
        return "redirect:querybyvo";
    }

    @RequestMapping("toupdate")
    public String toupdate(HttpServletRequest request, int id) {
        Msmerchant msmerchant = msmerchantService.queryMsmerchantById(id);
        request.setAttribute("msmerchant", msmerchant);
        return "msmerchant/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, Msmerchant msmerchant) {
        msmerchantService.updateMsmerchant(msmerchant);
        System.out.println(msmerchant);
        return "redirect:querybyvo";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, int id) {
        msmerchantService.deleteMsmerchantById(id);
        return "redirect:querybyvo";
    }

    @RequestMapping("querybyid")
    public String querybyid(HttpServletRequest request, int id) {
        Msmerchant msmerchant = msmerchantService.queryMsmerchantById(id);
        request.setAttribute("msmerchant", msmerchant);
        return "msmerchant/view";
    }

    @RequestMapping("querybyvo")
    public String querybyvo(HttpServletRequest request, MsmerchantVo msmerchantVo) {
        List<Msmerchant> msmerchantList = msmerchantService.queryMsmerchantByVo(msmerchantVo);
        request.setAttribute("msmerchantList", msmerchantList);
        return "msmerchant/list";
    }

}
