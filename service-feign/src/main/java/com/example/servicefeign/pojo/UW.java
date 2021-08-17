package com.example.servicefeign.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Data
@ToString
@TableName(value = "u_w")
public class UW {
    @TableField(value = "user_company_token")
    public String userCompanyToken;
    @TableField(value = "white_list")
    public String whiteList;
}
