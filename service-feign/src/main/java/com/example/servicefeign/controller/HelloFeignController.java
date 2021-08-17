package com.example.servicefeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.servicefeign.pojo.User;
import com.example.servicefeign.pojo.WhiteList;
import com.example.servicefeign.service.HelloFeignService;
import com.example.servicefeign.service.IUserServer;
import com.example.servicefeign.service.IWhiteListServer;
import com.example.servicefeign.util.ErrorCondition;
import com.example.servicefeign.util.IpUtil;
import com.example.servicefeign.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/token/")
public class HelloFeignController {
    private final Logger logger = LoggerFactory.getLogger(HelloFeignController.class);
    @Resource
    private HelloFeignService helloFeignService;
    /**
     * 查询当前ip是否在白名单
     */
    @Resource
    private IWhiteListServer iWhiteListServer;
    /**
     * 用户公司注册码以
     */
    @Resource
    private IUserServer iUserServer;

    /**
     * 拉取生产者信息
     * @param name
     * @param request
     * @return
     */
    @RequestMapping(value = "hi")
    public String sayHi(@RequestParam String name, HttpServletRequest request){
        String ipAddr = IpUtil.getIpAddr(request);
        return helloFeignService.sayHiFromClientOne(name);
    }
    //查看当前ip地址是否在白名单
    public JSONObject access(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Methods","*");
        synchronized (this.getClass()){
            String ipAddr = IpUtil.getIpAddr(request);
            WhiteList whiteList = new WhiteList();
            whiteList.setWhiteList(ipAddr);
            logger.info("ip地址:"+ipAddr);
            JSONObject ipWhiteList = iWhiteListServer.findIPWhiteList(whiteList);
            return ipWhiteList;
        }
    }
    //添加token

    /**
     *
     * @param token 用户唯一标识
     * @param url 用户传递的url参数
     * @param unlock 用户注册码
     * @param request
     * @param sign 用户的钥匙
     * @return
     */
    public JSONObject updateToken(String token,String url,String unlock,HttpServletRequest request,String sign){
        JSONObject jsonObject = new JSONObject();
        ErrorCondition errorCondition = new ErrorCondition();
        MD5Util md5Util = new MD5Util();
        try {
            //查询用户唯一标识和用户注册码是否存在
            User company = iUserServer.findCompany(token,unlock);
            logger.info(company.toString());
            if (company == null){
                jsonObject.put("code",errorCondition.CODE_ZHUANTAI_NULL);
                jsonObject.put("value",errorCondition.CODE_ZHUANTAI_1_VALUE);
                return jsonObject;
            }
            //进行计算得出钥匙和用户的钥匙进行对比
            String str = token + unlock;
            String md5 = md5Util.MD5(str);
            logger.info(md5);
            if (!md5.equals(sign)){  //如果失败
                jsonObject.put("code",errorCondition.CODE_ZHUANTAI_NULL);
                jsonObject.put("value",errorCondition.CODE_ZHUANTAI_1_VALUE);
                return jsonObject;
            }else {//如果成功
                str = str + url;
                logger.info(str);
                logger.info(md5Util.MD5(str));
                company.setCompanyToken(md5Util.MD5(str));
                String ipAddr = IpUtil.getIpAddr(request);
                jsonObject = iUserServer.updateUser(company,ipAddr);
                return jsonObject;
            }
        }catch (Exception e){
            jsonObject.put("code",errorCondition.CODE_ZHUANTAI_NULL);
            jsonObject.put("value",errorCondition.CODE_ZHUANTAI_1_VALUE);
            return jsonObject;
        }
    }
    @GetMapping(value = "verify")
    public String verify(HttpServletRequest request, HttpServletResponse response,String token,String url,String unlock,String sign){
        response.setHeader("Access-Control-Allow-Methods","*");
        synchronized (this.getClass()){
            JSONObject access = access(request, response);
            if (access.getString("code") != "0" && access.getString("value") != "ok"){
                return access.toString();
            }
            JSONObject jsonObject = updateToken(token, url, unlock, request,sign);
            logger.info(jsonObject.toString());
            return jsonObject.toString();
        }
    }
}
