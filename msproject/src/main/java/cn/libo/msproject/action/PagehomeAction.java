package cn.libo.msproject.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {

    @RequestMapping("tohome")
    public String tohome() {
        return "homepage/homepage";
    }
}
