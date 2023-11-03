package org.zerock.myweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy  //AOP를 위한 AspectJAutoProxy 어노테이션
@MapperScan(basePackages = "org.zerock.myweb.mapper")
public class MywebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywebApplication.class, args);
	}

}
