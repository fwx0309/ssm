package org.fwx;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName HelloWorldTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 15:30
 * @Version 1.0
 */
public class HelloWorldTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloworld = context.getBean("helloworld", HelloWorld.class);
        helloworld.say();
    }
}
