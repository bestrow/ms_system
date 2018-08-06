package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msmerchant;
import cn.libo.msproject.service.MsmerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("msmerchantAction")
public class MsmerchantAction {

    @Autowired
    private MsmerchantService msmerchantService;

    @RequestMapping("toadd")
    public String toadd(){
        return "msmerchant/add";
    }
    @RequestMapping("add")
    public void add(Msmerchant msmerchant){
        msmerchantService.insertMsmerchant(msmerchant);
        System.out.println(msmerchant);
    }
}
