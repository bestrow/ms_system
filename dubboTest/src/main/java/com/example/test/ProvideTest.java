package com.example.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProvideTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application-context-provide.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }

}
