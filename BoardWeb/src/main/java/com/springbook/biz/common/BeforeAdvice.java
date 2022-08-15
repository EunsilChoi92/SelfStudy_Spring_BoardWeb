package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class BeforeAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
//	@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")	//포인트컷 중복 선언 -> 외부 포인트컷 가져오기
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.printf("[사전 처리] %s() 메소드 ARGS 정보: %s\n", method, args[0].toString());
	}
}
