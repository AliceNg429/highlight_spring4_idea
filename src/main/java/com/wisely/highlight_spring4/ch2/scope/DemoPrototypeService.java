package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//1 声明Scope为Prototype。每次调用新建一个bean实例
public class DemoPrototypeService {
}