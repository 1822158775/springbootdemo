package com.example.eurekaclient.conteroll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test/")
public class TestConterll {
    public String hello(){
        Map map = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        return "ok";
    }
}
