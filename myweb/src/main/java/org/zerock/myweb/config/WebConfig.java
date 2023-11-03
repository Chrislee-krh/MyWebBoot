package org.zerock.myweb.config;


import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zerock.myweb.interceptor.BoardInterceptor;
import org.zerock.myweb.interceptor.LoginInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
			.addPathPatterns("/session/updatePage")
			.addPathPatterns("/session/myPage");
		List<String> paths = Arrays.asList(
				new String[] {"/board/delete","/board/update","/board/modify","/board/register"});
		registry.addInterceptor(new BoardInterceptor())
			.addPathPatterns(paths);
	}

	
	
	
	
}
