package com.example.servicefeign.service;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.pojo.WhiteList;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IWhiteListServer {
    List<WhiteList> queryAll();
    JSONObject findIPWhiteList(WhiteList whiteList);
}
