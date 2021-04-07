package sppringBootStudy001.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
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
