package com.wisely.highlight_spring4.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: wzn
 * Date: 2019/8/9 16:11
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class); //1使用AnnotationConfigApplicationContext作为Spring容器，接受输入一个配置类作为参数；
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class); //2获得声明配置的UseFunctionService的Bean。
        System.out.println(useFunctionService.SayHello("di"));
        context.close();
    }
}
