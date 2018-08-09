package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.service.MsproductdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("msorderAction")
public class MsorderAction {

    @Autowired
    private MsorderService msorderService;

    @Autowired
    private MsproductService msproductService;

    @Autowired
    private MsproductdetailService msproductdetailService;

    @RequestMapping("payorder")
    public String payorder(Msorder msorder) {
        msorder.setCreatetime(new Date());
        msorder.setPaystatus(1);
        String tradeserialnumber = UUID.randomUUID().toString();
        msorder.setTradeserialnumber(tradeserialnumber);
        msorderService.insertMsOrder(msorder);
        return "redirect:/pagehomeAction/tohome";
    }

    @RequestMapping(value = "topayorder", method = RequestMethod.POST)
    public String topayorder(HttpServletRequest request, int id, int num) {
        Msproduct msproduct = msproductService.queryMsproductById(id);
        Msproductdetail msproductdetail = msproductdetailService.queryMsproductdetailById(id);
        request.setAttribute("msproductdetail", msproductdetail);
        request.setAttribute("msproduct", msproduct);
        request.setAttribute("productnum", num);
        int payamount = msproduct.getMiaoshaprice() * num;
        request.setAttribute("payamount", payamount);
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        request.setAttribute("userid", msuser.getId());
        return "order/payorder";
    }
}
