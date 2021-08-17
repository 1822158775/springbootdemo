package com.example.servicefeign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.servicefeign.pojo.WhiteList;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IWhiteListMapper extends BaseMapper<WhiteList> {
    List<WhiteList> queryAll();
    WhiteList findIPWhiteList(WhiteList whiteList);
}
