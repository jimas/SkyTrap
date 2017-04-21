package com.jimas.weixin.skytrap.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Description 登录页面
 * @author weqinjia.liu
 * @Date 2017年4月19日
 */
@Controller
public class LoginController extends BaseController{
    
    private static final Logger logger=Logger.getLogger(LoginController.class);
     
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        
        
        
        return "login";
    }
}
