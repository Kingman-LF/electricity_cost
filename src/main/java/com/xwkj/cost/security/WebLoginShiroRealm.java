package com.xwkj.cost.security;

import com.xwkj.cost.model.PermissionInfo;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.PermissionInfoService;
import com.xwkj.cost.service.RoleInfoService;
import com.xwkj.cost.service.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Resource
 * @author
 */
public class WebLoginShiroRealm extends AuthorizingRealm {
    private static Log log = LogFactory.getLog(WebLoginShiroRealm.class);

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private RoleInfoService roleInfoService;
    @Resource
    private PermissionInfoService permissionInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo)principalCollection.getPrimaryPrincipal();

        System.out.println(userInfo.toString());

        List<RoleInfo> roleInfoList = roleInfoService.getRoleInfoByUserInfoId(userInfo.getId());
        if (roleInfoList != null && roleInfoList.size() != 0){
            for (RoleInfo r : roleInfoList){
                authorizationInfo.addRole(r.getRoleName());
                List<PermissionInfo> permissionsInfoList = permissionInfoService.getPermissionsInfoListByRoleId(r.getId());
                if (permissionsInfoList != null && permissionsInfoList.size() != 0){
                    for (PermissionInfo p : permissionsInfoList){
                        authorizationInfo.addStringPermission(p.getPerm());
                    }
                }
            }
        }


        /*UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        //查询用户角色信息
        List<RoleInfo> roleInfoList = userInfoService.findRolesByUserId(userInfo.getId());
        if(roleInfoList != null){
            for (RoleInfo role : roleInfoList) {
                authorizationInfo.addRole(role.getRoleName());
                List<Permission> permissionList = roleInfoService.findPermissionByRoleId(role.getId());
                if(permissionList != null){
                    for (Permission p : permissionList) {
                        authorizationInfo.addStringPermission(p.getPermssion());
                    }
                }
            }
        }*/
        return authorizationInfo;
    }

    //主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String username = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());

        UserInfo userInfo = userInfoService.checkUserInfo(username, password);
        if (userInfo == null) {
            return null;
        }
        if (userInfo.getIsEnable() == 0) { //账户冻结
            throw new LockedAccountException();
        }
        setSession("userInfo", userInfo);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                getName()  //realm name
        );

        return authenticationInfo;
    }
    /**
     * �����¼��
     */
    @SuppressWarnings("unused")
    private void setSession(Object key, Object value){
        Session session = getSession();
        if(null != session){
            session.setAttribute(key, value);
        }else{
            log.error("��ȡhttpServletSessionʧ�ܣ�");
        }
    }

    public Session getSession(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null){
                session = subject.getSession();
            }
            if (session != null){
                return session;
            }
        }catch (InvalidSessionException e){
            log.error(e + "shiro Ȩ����֤���HttpServletSessionʧ�ܣ�");
        }
        return null;
    }

}
