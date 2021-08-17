package com.example.servicefeign.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.mapper.IUMapper;
import com.example.servicefeign.mapper.IUserMapper;
import com.example.servicefeign.pojo.UW;
import com.example.servicefeign.pojo.User;
import com.example.servicefeign.service.IUserServer;
import com.example.servicefeign.util.ErrorCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Service
public class IUserServerImpl implements IUserServer {
    private final Logger logger = LoggerFactory.getLogger(IUserServerImpl.class);
    @Resource
    private IUserMapper iUserMapper;
    @Resource
    private IUMapper iuMapper;
    @Override
    public List<User> queryAll() {
        List<User> users = iUserMapper.queryAll();
        return users;
    }

    /**
     * 进行token值添加
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public JSONObject updateUser(User user,String ip) {
        ErrorCondition errorCondition = new ErrorCondition();
        Integer integer = iUserMapper.updateUser(user);
        JSONObject jsonObject = new JSONObject();
        if (integer == 1){
            jsonObject.put("code","0");
            jsonObject.put("value",user.getCompanyToken());
        }else {
            jsonObject.put("code",errorCondition.CODE_ZHUANTAI_NULL);
            jsonObject.put("value",errorCondition.CODE_ZHUANTAI_1_VALUE);
        }
        return jsonObject;
    }

    @Override
    public User findCompany(String token,String unlockKey) {
        User company = iUserMapper.findCompany(token,unlockKey);
        return company;
    }
}
