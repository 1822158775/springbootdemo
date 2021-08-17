package com.example.servicefeign.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.mapper.IWhiteListMapper;
import com.example.servicefeign.pojo.WhiteList;
import com.example.servicefeign.service.IWhiteListServer;
import com.example.servicefeign.util.ErrorCondition;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Service
public class IWhiteListServerImpl implements IWhiteListServer {
    private final Logger logger = LoggerFactory.getLogger(IWhiteListServerImpl.class);
    @Resource
    private IWhiteListMapper iWhiteListMapper;
    @Override
    public List<WhiteList> queryAll() {
        List<WhiteList> whiteLists = iWhiteListMapper.queryAll();
        return whiteLists;
    }

    /**
     * 查询当前访问的ip地址是否添加在数据库中
     * @param whiteList 访问接口的IP地址
     * @return
     * 1：没有
     * 0：存在
     */
    @Override
    public JSONObject findIPWhiteList(WhiteList whiteList) {
        WhiteList ipWhiteList = iWhiteListMapper.findIPWhiteList(whiteList);
        JSONObject object = new JSONObject();
        if (ipWhiteList == null){
            object.put("code","2");
            object.put("value","The IP address is not whitelisted");
            return object;
        }else {
            object.put("code","0");
            object.put("value","ok");
            return object;
        }
    }
}
