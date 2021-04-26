package sppringBootStudy001.com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sppringBootStudy001.com.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{

	private static final Map<String,String> userMap = new HashMap<String,String>();
	
	/**
	 * 
	 */
	public UserServiceImpl() {
		userMap.put("admin", "admin");
		userMap.put("zhangsan", "123");
	}
	
	/**
	 *
	 */
	@Override
	public boolean checkUser(String name) {
		return !StringUtils.isEmpty(userMap.get(name));
	}

	/**
	 *
	 */
	@Override
	public String getPwdByName(String name) {
		return userMap.get(name);
	}

}
