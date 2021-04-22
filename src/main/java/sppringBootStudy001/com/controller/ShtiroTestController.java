package sppringBootStudy001.com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sppringBootStudy001.com.service.UserService;

/**
 * shiro测试控制器
 * @author zhuyingzheng
 */
@Controller
public class ShtiroTestController {
	
	@Autowired
	private UserService userService;


	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "index";
	}

	@RequestMapping("/")
	public String root() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, Model model) {
		//获取权限操作对象，利用这个对象来完成登录操作
		Subject subject = SecurityUtils.getSubject();
		//是否认证过
		if(!subject.isAuthenticated()){
			//创建用户身份认证令牌，并设置成页面中的登录是传递的值
			UsernamePasswordToken usernameAndPasswordToken =
					new UsernamePasswordToken(username, password);
			try {
				//用户登录
				subject.login(usernameAndPasswordToken);
			}catch (AuthenticationException e){
				e.printStackTrace();
				model.addAttribute("errorMessage","认证失败");
				return "login";
			}
		}
		return "redirect:/succes"; //重定向到success
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/"; //重定向到根目录
	}
	
	@RequestMapping("/succes")
	public String success() {
		return "success";
	}
	
	@RequestMapping("/noPermissions")
	public String noPermission() {
		return "noPermission";
	}
	
	@RequestMapping("/admin/test")
	public @ResponseBody String adminTest() {
		return "Admin test 请求";
	}
	
	@RequestMapping("/user/test")
	public @ResponseBody String userTest() {
		return "user test 请求";
	}
}
