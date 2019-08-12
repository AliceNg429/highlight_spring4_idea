package com.wisely.highlight_spring4.ch3.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

//但是在实际项目中，你不可避免的要用到Spring容器本身
// 的功能资源，这时你的Bean必须要意识到Spring容器的存在，
// 才能调用Spring所提供的资源，这就是所谓的Spring Aware。
//Spring Aware演示Bean。
@Service
//实现BeanNameAware、ResourceLoaderAware接口，获得 Bean名称和资源加载的服务。
public class AwareService implements BeanNameAware, ResourceLoaderAware {//1
    private String beanName;
    private ResourceLoader loader;

    @Override
    //实现ResourceLoaderAware需重写setResourceLoader。
    public void setResourceLoader(ResourceLoader resourceLoader) {//2
        this.loader = resourceLoader;
    }

    @Override
    //实现BeanNameAware需重写setBeanName方法。
    public void setBeanName(String name) {//3
        this.beanName = name;
    }

    public void outputResult() {
        System.out.println("Bean的名称为：" + beanName);
        Resource resource = loader.getResource("classpath:com/wisely/highlight_spring4/ch2/aware/test.txt");
        try {
            System.out.println("ResourceLoader加载的文件内容 为: " + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}