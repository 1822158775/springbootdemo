package com.example.servicefeign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @avthor 潘小章
 * @date 2021/8/17
 */
@RestController
public class MController {
    @RequestMapping(value = "/hello")
    public String hello(){

        return "Hello Word";
    }
}
