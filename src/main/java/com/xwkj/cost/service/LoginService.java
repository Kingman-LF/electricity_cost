package com.xwkj.cost.service;

import com.xwkj.cost.model.UserInfo;

public interface LoginService {

    /**
     * @Description : 用户登录
     * @methodName : login
     * @param userInfo :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean login(UserInfo userInfo);
}
