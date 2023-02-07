package com.superhero.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimingAspect.class);
	
	@Around("@annotation(Timed)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		LOG.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), executionTime);
		return proceed;
	}
}
