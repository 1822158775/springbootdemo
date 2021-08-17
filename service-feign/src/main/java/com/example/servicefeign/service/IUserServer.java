package com.example.servicefeign.service;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.pojo.User;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IUserServer {
    List<User> queryAll();
    JSONObject updateUser(User user,String ip);
    User findCompany(String token,String unlockKey);
}
