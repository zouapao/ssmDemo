package com.ssmdemo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestInterface {
    @WebMethod
    public String diaoyong(String xm, String tel);
}
