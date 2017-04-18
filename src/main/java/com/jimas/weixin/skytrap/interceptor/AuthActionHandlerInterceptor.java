package com.jimas.weixin.skytrap.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class AuthActionHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger=Logger.getLogger(AuthActionHandlerInterceptor.class);
    

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod method =(HandlerMethod) handler;
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      // 验证用户是否登陆 TODO
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        
    }
}
