package org.zerock.myweb.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  //bean 자동 생성!!(컴포넌트 스캔시..)
@Aspect
public class LogAdvice {
	// 로그를 출력하는 기능을 구현한 Advice... 
	// 로그 출력을 위해서... src/main/resources에 log4j.xml에 레벨설정! 
	//<logger name="org.zerock.aop">
	//	<level value="info" />
	//</logger>
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//맨앞에 *는 접근제한자를 의미함. 맨뒤에 *는 메서드를 의미함.
	@Before("execution(* org.zerock.myweb.service.BoardServicempl*.*(..))")
//	@Before("execution(* org.zerock.board.service.BoardServiceImpl*.getContent(..))")
	public void beforeLog() {
		logger.info("-------Before 어노테이션 동작-------");
	}
 	
	//after AOP설정
	@After("execution(* org.zerock.myweb.service.BoardServiceImpl.*(..))")
	public void afterLog() {
		logger.info("-------After 어노테이션 동작---------");
	}
	
	//@Around : 메서드 실행 권한을 가지고, 실행전, 실행 후 처리 가능... 
	//  @Around가 적용되는 메서드(어드바이스)는 반드시 리턴이 존재해야 함. 
	@Around("execution(* org.zerock.myweb.service.BoardServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		long start = System.currentTimeMillis();  //시스템 시간(시작)
		
		//해당 기능을 통해서 메서드 실행 전 결과를 확인할 수 있음.
		System.out.println("적용 클래스 : "+jp.getTarget());
		System.out.println("적용 파라미터 : "+Arrays.toString(jp.getArgs()));

		Object result = null;
		
		try {
			//proceed()는 타겟 메서드를 지칭. 해당 메서드를 실행 시켜야 타겟이 되는 메서드가 실행됩니다.
			
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();  //시스템 시간(끝)
		System.out.println("메서드 수행에 걸린 시간 : "+ (end - start));
		return result;
	}
	
	//해당 어노테이션은 예외가 발생하면 동작...
	//pointcut- 어떤 메서드에 적용할 것인지... 
	//throwing- 처리할 에러변수
	@AfterThrowing(pointcut = "execution(* org.zerock.myweb.service.MemberService*.*(..))"
			,throwing = "e")
	public void errorLog(Exception e) {
		System.out.println("에러는 무언가요? "+e);
		logger.warn("심각한 에러입니다. : "+e);
	}
	

}
