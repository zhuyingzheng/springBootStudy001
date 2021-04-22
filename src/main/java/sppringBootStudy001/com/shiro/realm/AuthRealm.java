package sppringBootStudy001.com.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * 自定义relam用来负责用户的认证和授权
 * AuthenticatingRealm 只负责认证
 * */
public class AuthRealm  extends AuthenticatingRealm {

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
        String password = new String(token.getPassword());
        System.out.println(userName + ", " + password);
        return null;
    }
}
