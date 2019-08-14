package com.wisely.highlight_spring4.ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//SpringJUnit4ClassRunner在JUnit环境下提供Spring TestContext Framework的功能。
@RunWith(SpringJUnit4ClassRunner.class) //1
//@ContextConfiguration用来加载配置
//ApplicationContext，其中classes属性用来加载配置类。
@ContextConfiguration(classes = {TestConfig.class}) //2
//@ActiveProfiles用来声明活动的profile。
@ActiveProfiles("prod") //3
public class DemoBeanIntegrationTests {
    @Autowired //4
    private TestBean testBean;

    @Test //5
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}