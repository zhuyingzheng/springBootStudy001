package sppringBootStudy001.com.service;

/**
 * @author zhuyingzheng
 *
 */
public interface UserService {
	
	/**
	 * @return true or false
	 */
	boolean checkUser(String name);

	/**
	 * @return pwd
	 */
	String getPwdByName(String name);
	
}
