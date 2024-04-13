package org.fwx.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName ValidateAspect
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 23:30
 * @Version 1.0
 */
@Component
public class ValidateAspect {

    public void beforeAdviceMethod(){
        System.out.println("Xml 数据验证前置通知");
    }
}
