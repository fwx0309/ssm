package org.fwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ViewController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/13 19:03
 * @Version 1.0
 */
@Controller
public class ViewController {

    @RequestMapping("/thymeleafView")
    public String thymeleafView(){
        return "success";
    }

    @RequestMapping("/internalResourceView")
    public String internalResourceView(){
        return "forward:/hello";
    }

    @RequestMapping("/redirectView")
    public String redirectView(){
        return "redirect:/hello";
    }
}
