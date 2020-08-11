package com.kaush.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.kaush.pma.controllers..*)"
			+"|| within(com.kaush.pma.dao..*) ")
	public void definePackagePointcuts() {
		// empty method just to name the location specified in the pontcut
	}
	
	
	@Around("definePackagePointcuts()")
	public Object logDetailsArround(ProceedingJoinPoint pjp) {
		// this part will run before the given part
		log.debug("\n  \n  \n");
		log.debug("*************** Logging details before proceed *************  \n {}.{} () with argument[s] = {}", pjp.getSignature().getDeclaringTypeName(),
				pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
		log.debug("------------------------------------------------- \n \n \n");
		
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// this part will run after the given part
		log.debug("\n  \n  \n");
		log.debug("*************** Logging details after proceed *************  \n {}.{} () with argument[s] = {}", pjp.getSignature().getDeclaringTypeName(),
				pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
		log.debug("------------------------------------------------- \n \n \n");
		
		return o;
	}
	
}
