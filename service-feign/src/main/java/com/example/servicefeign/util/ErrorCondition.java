package com.example.servicefeign.util;

import lombok.Data;
import lombok.ToString;

/**
 * @avthor 潘小章
 * @date 2021/8/16
 */
@Data
@ToString
public class ErrorCondition {
    //状态码
    public String CODE_ZHUANTAI_NULL = "1";
    public String CODE_ZHUANTAT_IP = "2";
    //状态内容
    public String CODE_ZHUANTAI_1_VALUE = "Parameter error";
    public String CODE_ZHUANTAI_2_VALUE = "Parameter error";
}
