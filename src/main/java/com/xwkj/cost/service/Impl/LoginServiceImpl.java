package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.UserInfoMapperManual;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.LoginService;
import com.xwkj.cost.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserInfoMapperManual userInfoMapperManual;

    /**
     * @Description : 用户登录
     * @methodName : login
     * @param userInfo :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    @Override
    public Boolean login(UserInfo userInfo) {
        String password = MD5Util.getMD5(userInfo.getPassword());
        userInfo.setPassword(password);
        UserInfo user = userInfoMapperManual.getUserInfoByUserNameAndPassWord(userInfo);
        if (user == null){
            return false;
        }
        return true;
    }
}
