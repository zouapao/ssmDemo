package com.ssmdemo.service.impl;

import com.ssmdemo.service.TestInterface;

import javax.jws.WebService;

@WebService(targetNamespace = "http://com.ssmdemo.service.TestInterface",serviceName = "testInterface", endpointInterface = "com.ssmdemo.service.TestInterface")
public class TestInterfaceImpl implements TestInterface {
    @Override
    public String diaoyong(String xm, String tel) {
        return "这是接口";
    }
}
