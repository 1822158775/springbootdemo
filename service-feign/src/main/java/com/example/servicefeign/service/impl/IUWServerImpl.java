package com.example.servicefeign.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.mapper.IUMapper;
import com.example.servicefeign.pojo.UW;
import com.example.servicefeign.service.IUWServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Service
public class IUWServerImpl implements IUWServer {
    @Resource
    private IUMapper iuMapper;
    @Override
    public JSONObject findCompanyToken(String companyToken, String ip) {
        UW uw = iuMapper.findCompanyToken(companyToken);
        JSONObject jsonObject = new JSONObject();
        if (uw != null){
            jsonObject.put("code","0");
            jsonObject.put("value","ok");
        }else {
            jsonObject.put("code","1");
            jsonObject.put("value","Parameter error");
        }
        return jsonObject;
    }
}
