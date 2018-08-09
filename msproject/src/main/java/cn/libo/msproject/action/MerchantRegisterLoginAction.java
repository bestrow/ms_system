package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msmerchant;
import cn.libo.msproject.service.MsmerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

// 商家登录注册模块
@Controller
@RequestMapping("merchantRegisterLoginAction")
public class MerchantRegisterLoginAction {

    @Autowired
    private MsmerchantService msmerchantService;

    @RequestMapping("toregister")
    public String toregister() {
        return "msmerchant/toregister";
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Msmerchant msmerchant) {
        msmerchantService.insertMsmerchant(msmerchant);
        request.getSession().setAttribute("msmerchant", msmerchant);
        return "adminhomepage/homepage";
    }

    @RequestMapping("tologin")
    public String tologin() {
        return "msmerchant/tologin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Msmerchant msmerchant) {
        String returnUrl = "adminhomepage/error";
        String account = msmerchant.getMerchantaccount();
        String password = msmerchant.getMerchantpassword();

        Msmerchant result = msmerchantService.queryByaccount(account);
        if (result == null) {
            System.out.println("无此商家！");
            request.setAttribute("errorinfo", "无此商家");
        } else if (!result.getMerchantpassword().equals(password)) {
            System.out.println("商家密码错误！");
            request.setAttribute("errorinfo", "商家密码错误");
        } else {
            request.getSession().setAttribute("msmerchant", result);
            returnUrl = "adminhomepage/homepage";
        }
        return returnUrl;
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("msmerchant");
        return "adminhomepage/homepage";
    }

}
