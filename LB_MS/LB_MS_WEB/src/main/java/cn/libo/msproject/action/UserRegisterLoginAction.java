package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.service.MsuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

//用户注册登录
@Controller
@RequestMapping("userRegisterLoginAction")
public class UserRegisterLoginAction {

    @Autowired
    private MsuserService msuserService;

    @RequestMapping("toregister")
    public String toregister() {
        return "msuser/toregister";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Msuser msuser) {
        msuserService.insertMsuser(msuser);
        request.getSession().setAttribute("msuser", msuser);
        System.out.println(msuser);
        return "redirect:/pagehomeAction/tohome";
    }

    @RequestMapping("tologin")
    public String tologin() {
        return "msuser/tologin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Msuser msuser) {
        String returnUrl = "homepage/error";
        String account = msuser.getUseraccount();
        String password = msuser.getUserpassword();

        Msuser result = msuserService.queryMsuserByuseraccount(account);
        if (result == null) {
            System.out.println("无此用户！");
            request.setAttribute("errorinfo", "无此用户");
        } else if (!result.getUserpassword().equals(password)) {
            System.out.println("密码错误！");
            request.setAttribute("errorinfo", "密码错误");
        } else {
            request.getSession().setAttribute("msuser", result);
            returnUrl = "redirect:/pagehomeAction/tohome";
        }
        return returnUrl;
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("msuser");
        return "redirect:/pagehomeAction/tohome";
    }

}
