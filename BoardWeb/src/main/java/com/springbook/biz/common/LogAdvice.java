package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect	// Aspect = Pointcut + Advice
public class LogAdvice {
	
//	//포인트컷
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
//	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {}
//	
//	
//	//어드바이스
//	@Before("allPointcut()")
//	public void printLog(JoinPoint jp) {
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전동작");
//	}
	
	
	
}
