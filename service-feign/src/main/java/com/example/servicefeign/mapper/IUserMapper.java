package com.example.servicefeign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.servicefeign.pojo.User;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IUserMapper extends BaseMapper<User> {
    List<User> queryAll();
    Integer updateUser(User user);
    User findCompany(String token,String unlockKey);
}
