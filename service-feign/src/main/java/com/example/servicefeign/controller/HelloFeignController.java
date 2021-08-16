package com.example.servicefeign.controller;

import com.example.servicefeign.service.HelloFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloFeignController {
    @Resource
    private HelloFeignService helloFeignService;
    @RequestMapping(value = "hi")
    public String sayHi(@RequestParam String name){
        return helloFeignService.sayHiFromClientOne(name);
    }
}
