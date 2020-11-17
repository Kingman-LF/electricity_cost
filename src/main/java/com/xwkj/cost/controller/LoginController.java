package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.LoginService;
import com.xwkj.cost.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;


    @GetMapping("/login")
    public ModelAndView toLoginPage(){
        return new ModelAndView("login");
    }


    /**
     * @Description : 用户登录
     * @methodName : login
     * @param userInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PostMapping("/loginUser")
    public ResponseResult login(UserInfo userInfo){
        ResponseResult responseResult = null;
        try {
            /*Boolean b = loginService.login(userInfo);
            if (b){
                log.info("登录成功！");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null,"登录成功！");
            }else {
                log.error("用户名或密码错误！");
                responseResult = ResponseResult.failure("用户名或密码错误！");
            }*/
            UsernamePasswordToken token = new UsernamePasswordToken();
            token.setUsername(userInfo.getUserName());
            String password = MD5Util.getMD5(userInfo.getPassword());
            token.setPassword(password.toCharArray());
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated()) {
                subject.login(token);
            }
            log.info("登录成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(), null,"登录成功！");
        } catch(Exception e){
            e.printStackTrace();
            log.error("登录失败");
            responseResult = ResponseResult.failure("登录失败");
        }
        return responseResult;
    }

    /**
     * @Description : 取消登录
     * @methodName : logout
     * @return : org.springframework.web.servlet.ModelAndView
     * @exception : 
     * @author : zyh
     */
    @GetMapping("/logout")
    public ModelAndView logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return new ModelAndView("redirect:login");
    }

}
