package org.fwx.service.impl;

import org.fwx.service.ServiceTest;
import org.springframework.stereotype.Service;

/**
 * @ClassName ServiceTestImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/15 20:39
 * @Version 1.0
 */
@Service
public class ServiceTestImpl implements ServiceTest {

    @Override
    public void test() {
        System.out.println("ServiceTestImpl ...");
    }
}
