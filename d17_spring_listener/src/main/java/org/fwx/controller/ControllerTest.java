package org.fwx.controller;

import org.fwx.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ControllerTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/15 20:38
 * @Version 1.0
 */
@Controller
public class ControllerTest {

    @Autowired
    private ServiceTest serviceTest;

    @RequestMapping("/test")
    public String test(){
        System.out.println("ControllerTest = " + serviceTest);
        return "success";
    }
}
