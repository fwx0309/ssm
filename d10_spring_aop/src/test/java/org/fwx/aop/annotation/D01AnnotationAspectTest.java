package org.fwx.aop.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName LoggerAspectTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 23:08
 * @Version 1.0
 */
public class D01AnnotationAspectTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.add(1, 2);
        System.out.println("result = " + result);
    }
}
