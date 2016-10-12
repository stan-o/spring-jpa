/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.conf;

import com.so.webblog.info.DeviceInfo;
import com.so.webblog.info.UserSessionStorage;
import com.so.webblog.util.AuthenticationUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author user
 */
@WebFilter(filterName = "AuthCheckFilter", urlPatterns = {"/*"})
@Component
public class AuthCheckFilter implements Filter {
    
////    @Autowired
//    private UserSessionStorage userSessionsStorage;
    
    public AuthCheckFilter() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest)request;
        if(AuthenticationUtils.isAuthenticated()){
            saveDeviceAuthIfNotExist(r, (HttpServletResponse)response);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    
    @SuppressWarnings("PMD")
    private void saveDeviceAuthIfNotExist(HttpServletRequest req,
            HttpServletResponse response){
        if(UserSessionStorage.containsDeviceAuthentication(AuthenticationUtils.getCurrentUser(),
                getSessionId(req))){
            return;
        }
        UserSessionStorage.addAuthentication(AuthenticationUtils.getCurrentUser(),
                getSessionId(req),
                createDeviceInfo(req));
    }
    
    private DeviceInfo createDeviceInfo(HttpServletRequest request){
        String deviceId = request.getHeader("device-id");
        DeviceInfo.Device device;
        String deviceHeader = request.getHeader("x-origin") == null ? "": request.getHeader("x-origin");
        switch(deviceHeader){
            case "IOS": 
                device = DeviceInfo.Device.IOS;
                break;
            case "ANDROID":
                device = DeviceInfo.Device.ANDROID;
                break;
            default:
                device = DeviceInfo.Device.PC;
        }
        return new DeviceInfo(device, deviceId);
    }
    
    private String getSessionId(HttpServletRequest req){
        for(Cookie c : req.getCookies()){
            if(c.getName().equals("JSESSIONID")){
                return c.getValue();
            }
        }
        return null;
    }
}
