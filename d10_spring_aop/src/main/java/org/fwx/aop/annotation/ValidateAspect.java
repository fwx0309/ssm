package org.fwx.aop.annotation;

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
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("org.fwx.aop.annotation.LoggerAspect.pointCut()")
    public void beforeAdviceMethod(){
        System.out.println("数据验证前置通知");
    }
}
