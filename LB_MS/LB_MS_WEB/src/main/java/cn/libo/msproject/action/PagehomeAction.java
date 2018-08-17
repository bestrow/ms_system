package cn.libo.msproject.action;

import cn.libo.msproject.entity.Msproduct;
import cn.libo.msproject.entity.Msproductdetail;
import cn.libo.msproject.entity.Msuser;
import cn.libo.msproject.service.MsorderService;
import cn.libo.msproject.service.MsproductService;
import cn.libo.msproject.service.MsproductdetailService;
import cn.libo.msproject.service.redis.MsproductRedisService;
import cn.libo.msproject.service.redis.MsproductdetailRedisService;
import cn.libo.msproject.vo.MsproductVo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {
    @Autowired
    private MsproductService msproductService;

    @Autowired
    private MsproductdetailService msproductdetailService;

    @Autowired
    private MsproductRedisService msproductRedisService;

    @Autowired
    private MsproductdetailRedisService msproductdetailRedisService;

    @RequestMapping("tohome")
    public String tohome(HttpServletRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        Msproduct msproduct = new Msproduct();
        msproduct.setAuditstate(2);

        MsproductVo msproductVo = new MsproductVo();
        msproductVo.setMsproduct(msproduct);
        msproductVo.setStartendtime(dateString);

        List<Msproduct> msproductList = msproductService.listMsproduct(msproductVo);
        request.setAttribute("msproductList", msproductList);
        return "homepage/homepage";
    }

    @RequestMapping("viewproductdetail")
    public String viewproductdetail(HttpServletRequest request, int id) {
        Msproduct msproduct = msproductRedisService.queryMsproductById(id);
        Msproductdetail msproductdetail = msproductdetailRedisService.queryMsproductdetailById(id);
        request.setAttribute("msproduct", msproduct);
        request.setAttribute("msproductdetail", msproductdetail);
        return "order/selldetail";
    }

    @RequestMapping("produceHtml")
    public void produceHtml(HttpServletRequest request) {
        String htmlPath = request.getRealPath("/WEB-INF/html/"); //得到html的绝对路径
        //得到请求信息
        String contextpath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        contextpath = contextpath + "/pagehomeAction/tohome";
        System.out.println("htmlPath: " + htmlPath);
        System.out.println("contextpath: " + contextpath);

        CloseableHttpClient client = HttpClients.createDefault();//得到客户端
        HttpGet httpGet = new HttpGet(contextpath);
        CloseableHttpResponse response = null;

        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);

            //看请求是否成功，这儿打印的是http状态码
            System.out.println(response.getStatusLine().getStatusCode());
            //4.获取响应的实体内容，就是我们所要抓取得网页内容
            HttpEntity entity = response.getEntity();

            //5.将其打印到控制台上面
            //方法一：使用EntityUtils
            if (entity != null) {
                String html = EntityUtils.toString(entity);
                File file = new File(htmlPath + "/index.html");//存到应用的htmlPath目录下
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
                writer.write(html);
                writer.flush();
                writer.close();
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("producejs")
    public void producejs(HttpServletRequest request) {
        String jsPath = request.getRealPath("/WEB-INF/classes/js/");
        String jscontent = "function remaintime() {\n" +
                "    var starttime = $(\"#starttime\").html();\n" +
                "    var s1 = new Date(starttime.replace(\"/-/g\", \"/\"));\n" +
                "    var s2 = new Date();\n" +
                "    var date3 = s2.getTime() - s1.getTime();\n" +
                "    if (date3 > 2) {\n" +
                "        $(\"#sellbtn\").attr({\"disabled\": \"disabled\"});\n" +
                "        var days = Math.floor(date3 / (24 * 3600 * 1000));\n" +
                "        var leave = date3 % (24 * 3600 * 1000);\n" +
                "        var hours = leave / (3600 * 1000);\n" +
                "        var leave1 = leave % (3600 * 1000);\n" +
                "        var minutes = Math.floor(leave1 / (60 * 1000));\n" +
                "        var leave2 = leave1 % (60 * 1000);\n" +
                "        var seconds = Math.floor(leave2 / 1000);\n" +
                "        $(\"#remainnoties\").html(\"相差\" + days + \"天\" + hours + \"小时\" + minutes + \"分钟\" + seconds + \"秒\");\n" +
                "    } else {\n" +
                "        $(\"#remainnoties\").html(\"\");\n" +
                "        $(\"#sellbtn\").removeAttr(\"disabled\");\n" +
                "        $(\"sellbtn\").parent().attr(\"action\",\"/msorderAction/topayorder\");\n" +
                "    }\n" +
                "}\n" +
                "setInterval('remaintime()', 500);";
        File file = new File(jsPath + "/remain.js");
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            writer.write(jscontent);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @RequestMapping("getuser")
    @ResponseBody
    public String getUser(HttpServletRequest request) {
        Msuser msuser = (Msuser) request.getSession().getAttribute("msuser");
        String account = "";
        if (msuser != null) {
            account = msuser.getUseraccount();
        }
        return account;
    }

}
