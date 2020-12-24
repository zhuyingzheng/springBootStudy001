package sppringBootStudy001.com.aop;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class TargetInstance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void say() {
		System.out.println("我是目标方法 。。。");
	}
}
