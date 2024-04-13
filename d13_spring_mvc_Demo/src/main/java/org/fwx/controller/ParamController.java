package org.fwx.controller;

import org.fwx.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName TestParamController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/13 13:31
 * @Version 1.0
 */

@Controller
public class ParamController {

    @RequestMapping(value = "/param/servletApi")
    public String getParamByServletApi(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping(value ="/param")
//    public String getParamBySpringMvc(String username,String password){
    public String getParamBySpringMvc(
            @RequestParam("name") String username,
            String password,
            @RequestHeader("Referer") String referer,
            @CookieValue("JSESSIONID") String jsessionid){
        System.out.println("referer = " + referer);
        System.out.println("jsessionid = " + jsessionid);

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamFromPojo(User user){
        System.out.println("user.getUsername() = " + user.getUsername());
        System.out.println("user.getPassword() = " + user.getPassword());
        return "success";
    }
}
