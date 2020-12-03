package sppringBootStudy001.com.aop;

import org.springframework.stereotype.Component;

@Component
public class TargetInstance {
	
	public void say() {
		System.out.println("我是目标方法 。。。");
	}
}
