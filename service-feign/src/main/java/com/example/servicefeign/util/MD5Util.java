package com.example.servicefeign.util;

import org.springframework.util.DigestUtils;

/**
 * @avthor 潘小章
 * @date 2021/8/17
 */

public class MD5Util {
    public String MD5(String str){
        String s = DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex(str.getBytes()).getBytes());
        return s;
    }
}
