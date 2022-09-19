package com.books.app.handler;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ログ出力 AOPクラス
 *
 */
@Aspect
@Component
public class LoggingAspects {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspects.class);

    /**
     * コントローラーの処理の直前にログを出力するAOP
     * 
     * @param joinPoint
     */
    @Before("execution(* com.books.app.controller.*Controller.*(..))")
    public void controllerStartLog(JoinPoint joinPoint) {
        String string = joinPoint.toString();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("executeMethod {}, args: {}", string, args);
    }

    /**
     * コントローラーの処理が終了した後にログを出力するAOP
     * 
     * @param joinPoint
     * @param returnValue コントローラーからの戻り値
     */
    @AfterReturning(value = "execution(* com.books.app.controller.*Controller.*(..))", returning = "returnValue")
    public void controllerEndLog(JoinPoint joinPoint, Object returnValue) {
    	String string = joinPoint.toString();
    	String returns = returnValue.toString();
    	
    	logger.info("finishMethod {}, returns: {}", string, returns);
    }
    
    /**
     * エラーハンドリング用AOP
     * 
     * @param joinPoint
     * @param e スローされた例外
     */
    @AfterThrowing(value = "execution(* com.books.app.controller.*Controller.*(..))", throwing = "e")
    public void afterException(JoinPoint joinPoint, Exception e) {
        String string = joinPoint.toString();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.error("Error!, Exception: {}, {}, args = {}", e.getMessage(), string, args, e);
    }
}
