package org.zerock.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	
	//preHandle 메서드는 컨트롤러를 실행하기 전에 요청을 가로채 처리...
	//일반적으로 로그인, 세션 처리에 사용
	//preHandle에 세션 처리를 했다면, 스프링 설정 파일에 <interceptor> 태그를 이용해 맵핑 설정!!
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("PreHandle 동작!");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("/session/loginPage");
			return false;
			// 의미는 핸들러메서드를 실행한 후 Controller를 수행하지 않음.... 
		}else {
			return true;
			// 의미는 핸들러메서드를 실행한 후에 Controller를 수행한다는 의미... 
		}
	}

	// preHandler에서 true를 리턴하여, 컨트롤러를 실행했을 때만 동작함.... 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("PostHandle이 동작 해요!!");
		
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	

}
