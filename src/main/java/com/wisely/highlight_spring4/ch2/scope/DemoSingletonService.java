package com.wisely.highlight_spring4.ch2.scope;
import org.springframework.stereotype.Service;

@Service //1 默认为Singleton，相当于@Scope（“singleton”）。一个Spring容器中只有一个bean实例
public class DemoSingletonService {
}