package com.example.servicefeign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.servicefeign.pojo.UW;

import java.util.List;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */

public interface IUMapper extends BaseMapper<UW> {
    UW findCompanyToken(String companyToken);
    Integer insertCompanyToken(UW uw);
}
