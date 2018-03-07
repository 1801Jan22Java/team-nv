package com.revature.aspect;

//import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="loggingAspect")
public class LoggingAspect {
	//could be configured as a bean
	/*
		private static Logger log = Logger.getRootLogger();
		
		@AfterThrowing("within(com.revature.*)")
		public void logAfterThrow(JoinPoint jp){
			System.out.println("here");
			log.error(jp.getSignature());
		}*/
}
