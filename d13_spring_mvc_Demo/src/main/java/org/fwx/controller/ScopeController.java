package org.fwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * @ClassName ScopeController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/13 17:30
 * @Version 1.0
 */
@Controller
public class ScopeController {
    @RequestMapping("/modelAndView")
    public ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("modelAndView","test modelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/model")
    public String getModel(Model model){
        model.addAttribute("modelAndView","test model");
        return "success";
    }

    @RequestMapping("/modelMap")
    public String getModelMap(ModelMap modelMap){
        modelMap.addAttribute("modelAndView","test modelMap");
        return "success";
    }

    @RequestMapping("/map")
    public String getMap(Map map){
        map.put("modelAndView","test map");
        return "success";
    }

    @RequestMapping("/session")
    public String getSession(HttpSession httpSession){
        httpSession.setAttribute("session","test session");
        return "success";
    }

    @RequestMapping("/application")
    public String getApplication(HttpSession httpSession){
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("application","test application");
        return "success";
    }
}
