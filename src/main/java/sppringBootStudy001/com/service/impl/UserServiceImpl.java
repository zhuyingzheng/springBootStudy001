package sppringBootStudy001.com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sppringBootStudy001.com.service.UserService;

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
		userMap.put("zhangsan", "123456");	
	}
	
	/**
	 *
	 */
	@Override
	public boolean checkUser(String name) {
		return StringUtils.isEmpty(userMap.get(name))?false:true;
	}

}
