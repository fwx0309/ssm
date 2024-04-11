package org.fwx;

import org.fwx.pojo.Clazz;
import org.fwx.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName D01GetBeanTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 15:49
 * @Version 1.0
 */
public class D01GetBeanTest {
    /**
     * 获取bean的三种方式：
     * 1、根据bean的id获取
     * 2、根据bean的类型获取
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     * 若有多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
     * 3、根据bean的id和类型获取
     * 结论：
     * 根据类型来获取bean时，在满足bean唯一性的前提下
     * 其实只是看：『对象 instanceof 指定的类型』的返回结果
     * 只要返回的是true就可以认定为和类型匹配，能够获取到。
     * 即通过bean的类型、bean所继承的类的类型、bean所实现的接口的类型都可以获取bean
     */
    @Test
    public void getBeanTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Student student = (Student) context.getBean("studentOne");
        // *** 根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
        // Student student = context.getBean(Student.class);
        Student student = context.getBean("studentSix", Student.class);
        System.out.println("student = " + student);

        System.out.println("------------");

        // 内部类不能获取
        /*Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        System.out.println(clazz);*/

        /*Clazz clazz = context.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/
    }

    @Test
    public void diTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        // Student student = context.getBean("studentOne", Student.class);
        // Student student = context.getBean("studentTwo", Student.class);
        // Student student = context.getBean("studentThree", Student.class);
        // Student student = context.getBean("studentFour", Student.class);
        Student student = context.getBean("studentFive", Student.class);
        System.out.println("student = " + student);
    }
}
