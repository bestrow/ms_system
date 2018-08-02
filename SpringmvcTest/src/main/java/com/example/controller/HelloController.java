package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bestrow
 * @date 2018/8/2 20:31
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("test")
    public void hello(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.print("hello=="+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
