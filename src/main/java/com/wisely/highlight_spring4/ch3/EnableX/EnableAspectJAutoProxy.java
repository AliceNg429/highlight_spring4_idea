package com.wisely.highlight_spring4.ch3.EnableX;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

//第三类：动态注册Bean
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(AspectJAutoProxyRegistrar.class)
@Documented
public @interface EnableAspectJAutoProxy {
    boolean proxyTargetClass() default false;
}