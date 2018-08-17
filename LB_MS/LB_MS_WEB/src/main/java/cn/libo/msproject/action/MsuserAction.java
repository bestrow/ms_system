package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.service.MsuserService;
import cn.libo.msproject.vo.MsuserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("msuserAction")
public class MsuserAction {

    @Autowired
    private MsuserService msuserService;

    @RequestMapping("toadd")
    public String toadd() {
        return "msuser/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Msuser msuser) {
        msuserService.insertMsuser(msuser);
        System.out.println(msuser);
        return "redirect:querybyvo";
    }

    @RequestMapping("toupdate")
    public String toupdate(HttpServletRequest request, int id) {
        Msuser msuser = msuserService.queryMsuserById(id);
        request.setAttribute("msuser", msuser);
        return "msuser/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, Msuser msuser) {
        msuserService.updateMsuser(msuser);
        System.out.println(msuser);
        return "redirect:querybyvo";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, int id) {
        msuserService.deleteMsuserById(id);
        return "redirect:querybyvo";
    }

    @RequestMapping("querybyid")
    public String querybyid(HttpServletRequest request, int id) {
        Msuser msuser = msuserService.queryMsuserById(id);
        request.setAttribute("msuser", msuser);
        return "msuser/view";
    }

    @RequestMapping("querybyvo")
    public String querybyvo(HttpServletRequest request, MsuserVo msuserVo) {
        List<Msuser> msuserList = msuserService.queryMsuserByVo(msuserVo);
        request.setAttribute("msuserList", msuserList);
        return "msuser/list";
    }

}
