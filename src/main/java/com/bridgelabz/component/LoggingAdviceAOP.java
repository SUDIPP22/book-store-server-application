//package com.bridgelabz.component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//@Slf4j
//public class LoggingAdviceAOP {
//
//    @Pointcut(value = "execution(* com.bridgelabz.*.*.*(..) )")
//    public void myPointCut() {
//    }
//
//    @Around("myPointCut()")
//    public Object applicationLogger(ProceedingJoinPoint point) throws Throwable {
//        ObjectMapper mapper = new ObjectMapper();    // to get the outputs in JSON format
//        String methodName = point.getSignature().getName();    // to get the method name
//        String className = point.getTarget().getClass().toString(); // to get the class name
//        Object[] array = point.getArgs();                            // to get the inputs
//        log.info("method invoked" + className + " : " + methodName + "()" + "arguments : "
//                + mapper.writeValueAsString(array));
//        Object object = point.proceed();
//        // after executing  the method to get back the response of that particular class or method
//        log.info(className + " : " + methodName + "()" + "Response : "
//                + mapper.writeValueAsString(object));
//        return object;
//    }
//}
