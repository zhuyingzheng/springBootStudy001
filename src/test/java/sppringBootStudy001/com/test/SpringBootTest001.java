package sppringBootStudy001.com.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sppringBootStudy001.com.aop.TargetInstance;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTest001 {
	Logger logger = Logger.getLogger(SpringBootTest001.class);
	
	//@Autowired
	//Bean001 bean001;
	
	@Autowired
	TargetInstance targetInstance;
			
//	@Test
//	public void testReadYaml() {
//		
//		logger.info(bean001.getSyame());
//	}
	
	@Test
	public void testProxy() {
		targetInstance.say();
	}
}
