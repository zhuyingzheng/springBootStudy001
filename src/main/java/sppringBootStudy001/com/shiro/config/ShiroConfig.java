package sppringBootStudy001.com.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sppringBootStudy001.com.shiro.realm.AuthRealm;

/**
 * @author zhuyingzheng
 * 标注这是shiro的配置类，用于模拟spring的配置文件，在这里配置shiro
 */
@Configuration
public class ShiroConfig {
	
	/**
	 * 配置安全管理器
	 * @return SecurityManager
	 */
	@Bean
	public SecurityManager securityManager(Realm authRealm) {
		DefaultSecurityManager defaultSecurityManager = 
				new DefaultWebSecurityManager();
		//设置一个realm，这个realm是最终帮我们完成认证和授权的具体对象
		defaultSecurityManager.setRealm(authRealm);
		return defaultSecurityManager;
	}
	
	/**
	 * @return AuthRealm
	 * 自定义一个bean，最终使用这个bean返回的对象来完成我们的认证
	 */
	@Bean
	public AuthRealm authRealm() {
		return new AuthRealm();
	}
	
	/**
	 * 配置一个shiro的过滤器bean，这个bean将配置shiro相关的一个规则的拦截
	 * 例如什么样的请求可以访问，什么样的请求不可以访问
	 * @return ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFileter(SecurityManager securityManager) {
		//创建过滤器配置bean
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/");//设置用户登录请求 如果需要登录 shiro就会转到这个请求进入登录页面
		shiroFilterFactoryBean.setSuccessUrl("/success");//配置登录成功后转向的请求
		shiroFilterFactoryBean.setUnauthorizedUrl("/noPermission");//配置没有权限是转向的请求地址
		
		//配置权限拦截规则
		Map<String,String> filterChainMap = new LinkedHashMap<String,String>();
		filterChainMap.put("/index", "anon");//配置index请求不需要认证
		filterChainMap.put("/login", "anon");//配置登录请求不需要认证
		filterChainMap.put("/logout", "logout");//配置登出请求会清空当前用户的内存（释放session会话）
		filterChainMap.put("/admin/**", "authc");//配置admin请求开头的登录需要登录认证
		//配置剩余的请求都需要登录认证，这个必须写在最后，可选的配置
		filterChainMap.put("/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
		return shiroFilterFactoryBean;
	}
}
