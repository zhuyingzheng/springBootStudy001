package sppringBootStudy001.com.shiro.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import sppringBootStudy001.com.service.UserService;

/**
 * 自定义relam用来负责用户的认证和授权
 * AuthenticatingRealm 只负责认证
 * */
public class AuthRealm  extends AuthenticatingRealm {

    @Autowired
    private UserService userService;

    /**
     * 该方法不能手动调用，由shiro自动调用
     * @param authenticationToken 用户的身份，这里存账号密码
     * @return 返回用户登录成功后的身份证明
     * @throws AuthenticationException 如果认证失败，shiro会抛出各种异常
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        //String password = new String(token.getPassword());
        boolean authFlag = userService.checkUser(userName);
        System.out.println("认证结果：" + authFlag);
        /* --------------------------------
        * |用户不存在，抛出异常               |
        * |可根据不同的情况抛出不同的异常       |
        * =================================
        * */
        if(!authFlag){
            throw new UnknownAccountException();
        }
        //创建密码认证对象，由shiro自动认证，参数1：数据库账号或页面账号 ，参数2：数据库中读取到的密码，参数3：当前realm的名字
        //如果密码认证成功，返回用户认证对象
        return new SimpleAuthenticationInfo(userName,userService.getPwdByName(userName),getName());
    }
}
