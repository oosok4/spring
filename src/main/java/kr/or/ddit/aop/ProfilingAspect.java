package kr.or.ddit.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAspect {
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);
	 /*
	public void before(JoinPoint joinPoint) {
		logger.debug("before time : {}",new Date());
	}
	
	public void after(JoinPoint joinPoint) {
		logger.debug("after time : {}", new Date());
	}
	*/
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//business logic 실행 전
		logger.debug("logging Aspect Around method Before : {}",System.currentTimeMillis());
		
		//business logic 실행
		//logger.debug("method name : {}",joinPoint.getSignature().getName());
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 900000000; i++) {
			startTime -= i;
		}
		long endTime = System.currentTimeMillis();
		//logger.debug("차이 : {}",endTime-startTime);
		
		Object[] methodArgs = joinPoint.getArgs(); // 이거 잘 이해 안간다.
		Object returnObj = joinPoint.proceed(methodArgs);
		
		//business logic 실행 후
		logger.debug("logging Aspect Around method after  : {}",System.currentTimeMillis());
		
		
		return returnObj;
		
	}
	
	
	
	
	

}
