package com.example.servicefeign.service;

import com.example.servicefeign.service.impl.HelloFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "eureka-client-01", fallback = HelloFeignServiceImpl.class)
public interface HelloFeignService {
    @RequestMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
