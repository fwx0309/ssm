package org.fwx.aop.annotation;

import org.fwx.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName D02XmlAspectTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 11:30
 * @Version 1.0
 */
public class D02XmlAspectTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(1,1);
    }
}
