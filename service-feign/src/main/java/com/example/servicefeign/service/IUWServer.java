package com.example.servicefeign.service;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.pojo.UW;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IUWServer {
    JSONObject findCompanyToken(String companyToken,String ip);
}
