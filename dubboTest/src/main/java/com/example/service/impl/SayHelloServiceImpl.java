package com.example.service.impl;

import com.example.service.SayHelloService;

public class SayHelloServiceImpl implements SayHelloService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
