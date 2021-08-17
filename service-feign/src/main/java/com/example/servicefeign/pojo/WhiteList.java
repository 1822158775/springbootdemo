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
@TableName(value = "ip_white_list")
public class WhiteList {
    @TableId(value = "id",type = IdType.AUTO)
    public Integer id;
    @TableField(value = "name")
    public String name;
    @TableField(value = "white_list")
    public String whiteList;
}
