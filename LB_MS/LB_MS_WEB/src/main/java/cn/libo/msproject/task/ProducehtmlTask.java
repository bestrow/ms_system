package cn.libo.msproject.task;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


@Controller
public class ProducehtmlTask {

    public void produceHtml() {
     String url = "http://127.0.0.1:8080/pagehomeAction/produceHtml";

        CloseableHttpClient client = HttpClients.createDefault();//得到客户端
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);

            //看请求是否成功，这儿打印的是http状态码
            System.out.println("ProducehtmlTask == "+response.getStatusLine().getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

