
package com.zensar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

import com.zensar.exceptions.CopounExistsAlready;
import com.zensar.exceptions.NoSuchExistAlready;



@Aspect
@Configuration
public class MyAspect {
	
	private Logger log = LoggerFactory.getLogger(MyAspect.class);

	@Before(value="execution(* com.zensar.controller.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Execution Started {}", joinPoint);
	}

	@After(value="execution(* com.zensar.controller.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Done with executing of {}",  joinPoint);
	}

	@Around(value = "execution(* com.zensar.service.*.*(..))")
	public Object exceptionHandler(ProceedingJoinPoint  joinPoint) throws Throwable {
		try {
			Object obj = joinPoint.proceed();
			 return obj;
		}
		catch(NoSuchExistAlready e) {
			log.info("Message {}",e.getMessage());
		}
		catch(CopounExistsAlready e) {
			log.info("Message {}",e.getMessage());
		}
		return null;

	}


	@Around(value = "execution(* com.zensar.controller.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		try {
			Object obj = joinPoint.proceed();
			long timeTaken = System.currentTimeMillis()-startTime;
			log.info("Time  consumed {} --> {} ",joinPoint,timeTaken);
			return obj;
		}
		catch(NoSuchExistAlready e) {
			log.info("Information {}",e.getMessage());
		}
		catch(CopounExistsAlready e) {
			log.info("Information {}",e.getMessage());
		}
		return null;

	}
}