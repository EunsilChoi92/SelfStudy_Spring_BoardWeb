package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();

		stopWatch.stop();
		
		System.out.printf("%s() 메소드 수행에 걸린 시간: %s(ms)초\n", method, stopWatch.getTotalTimeMillis());
		
		return obj;
	}
}
