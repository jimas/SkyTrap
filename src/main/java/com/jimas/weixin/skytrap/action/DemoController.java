package com.jimas.weixin.skytrap.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController extends BaseController{

    
    @RequestMapping("/demo")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        
        return "demo";
    }
    @RequestMapping("/city")
    public String city(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        
        return "city";
    }
}
