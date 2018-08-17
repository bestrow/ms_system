package cn.libo.msproject.task;

import cn.libo.msproject.entity.Msorder;
import cn.libo.msproject.service.MsorderService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;


@Controller
public class CheckOrderTimeOutTask {

    @Autowired
    private MsorderService msorderService;

    public void CheckTimeOutOrder(long miniutes) {
        List<Msorder> msorderList = msorderService.listMsorder();
        for (Msorder msorder : msorderList) {
            Date createtime = msorder.getCreatetime();
            Date paytime = msorder.getPaytime();
            if (paytime != null) {
                continue;
            } else {
                Long timeDistance = System.currentTimeMillis() - createtime.getTime();
                Long miniute = timeDistance / 60 * 1000;
                if (miniute > miniutes) {
                    //订单取消
                    msorderService.updateflagById(1,msorder.getId());
                }
            }
        }
        System.out.println("CheckTimeOutOrder");
    }
}

