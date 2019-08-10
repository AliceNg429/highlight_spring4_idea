package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

//5.编写切面。
@Aspect //1 通过@Aspect注解声明一个切面。
@Component //2 通过@Component让此切面成为Spring容器管理的Bean。
public class LogAspect {
    //通过@PointCut注解声明切点。
    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3
    public void annotationPointCut() {};

    //通过@After注解声明一个建言，并使用@PointCut定义的切点。
    @After("annotationPointCut()") //4
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        //通过反射可获得注解上的属性，然后做日志记录相关的
        //操作，下面的相同。
        System.out.println("注解式拦截 " + action.name()); //5
    }

    //⑥通过@Before注解声明一个建言，此建言直接使用拦截
    //规则作为参数。
    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        //todo 感觉这里可以获取方法的参数值，下回实验
//        Object[] paramValues = new Object[parameters.length];

//        for(Parameter parameter:parameters){
//            String value = parameter.getName();
//            paramValues[0] = value;
//        }
//        try {
//            String invoke = (String)method.invoke(method.getClass(), paramValues[0]);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        System.out.println("方法规则式拦截," + method.getName());
    }
}