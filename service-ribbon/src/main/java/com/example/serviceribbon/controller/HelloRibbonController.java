package com.example.serviceribbon.controller;

import com.example.serviceribbon.service.HelloRibbonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloRibbonController {
    @Resource
    HelloRibbonService helloRibbonService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloRibbonService.hiService(name);
    }
}
