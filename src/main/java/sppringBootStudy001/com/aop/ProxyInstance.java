package sppringBootStudy001.com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProxyInstance {
	
	@Before(value = "execution(* sppringBootStudy001.com.aop.TargetInstance.say(..))")
	public void before() {
		System.out.println("我是方法前置增强");
	}

}
