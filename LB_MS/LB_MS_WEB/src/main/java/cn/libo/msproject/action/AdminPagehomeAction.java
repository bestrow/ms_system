package cn.libo.msproject.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adminPagehomeAction")
public class AdminPagehomeAction {

    @RequestMapping("tohome")
    public String tohome() {
        return "adminhomepage/homepage";
    }
}
