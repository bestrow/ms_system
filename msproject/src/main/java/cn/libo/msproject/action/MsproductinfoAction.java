package cn.libo.msproject.action;

import cn.libo.msproject.service.MsproductinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("msproductinfoAction")
public class MsproductinfoAction {

    @Autowired
    private MsproductinfoService msproductinfoService;


}
