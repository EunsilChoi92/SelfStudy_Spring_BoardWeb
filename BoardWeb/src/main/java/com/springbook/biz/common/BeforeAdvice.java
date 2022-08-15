package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.printf("[사전 처리] %s() 메소드 ARGS 정보: %s\n", method, args[0].toString());
	}
}
