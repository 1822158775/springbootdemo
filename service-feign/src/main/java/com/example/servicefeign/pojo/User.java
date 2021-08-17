package com.example.servicefeign.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Data
@ToString
@TableName(value = "user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    public Integer id;
    @TableField(value = "company")
    public String company;
    @TableField(value = "token")
    public String token;
    @TableField(value = "company_token")
    public String companyToken;
    @TableField(value = "unlock_key")
    public String unlockKey;
}
