package sppringBootStudy001.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("sppringBootStudy001.com.dao")
@SpringBootApplication //springboot主程序注解
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
