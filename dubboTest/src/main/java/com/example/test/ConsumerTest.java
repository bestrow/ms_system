package com.example.test;

import com.example.service.SayHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application-context-consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        SayHelloService sayHelloService =  (SayHelloService)context.getBean("sayhello");
        // execute remote invocation
        String hello = sayHelloService.sayHello("小小");
        // show the result
        System.out.println(hello);
    }

}
