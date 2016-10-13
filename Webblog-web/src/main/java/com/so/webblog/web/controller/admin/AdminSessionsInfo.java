/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.web.controller.admin;

import com.so.webblog.info.UserSessionStorage;
import com.so.webblog.util.AuthenticationUtils;
import java.util.Map;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AdminSessionsInfo {
    @Autowired
    private SessionRegistry sessionRegistry;
    
    @RequestMapping(value = {"/admin/sessions"}, method = RequestMethod.GET)
    public ModelAndView getAllSessions(){
        ModelAndView mv = new ModelAndView("admin/sessions/sessions-list");
        Map activeSessions = UserSessionStorage.getAllUserOrigins(AuthenticationUtils.getCurrentUser());
        mv.addObject("sessions", activeSessions.keySet().toArray());
        mv.addObject("sessionsInfo", activeSessions.values().toArray());
        mv.addObject("len", activeSessions.values().toArray().length);
        return mv;
    }
    
    @RequestMapping(value = {"/admin/sessions/invalidate"}, method = RequestMethod.POST)
    @ResponseBody
    public String invalidateSession(@RequestParam("sid") String sid, HttpServletRequest req, HttpServletResponse resp){
        for(SessionInformation sif : sessionRegistry.getAllSessions(AuthenticationUtils.getCurrentUser(), false)){
            System.out.println("sif = " + sif.getSessionId());sif.expireNow();
            if(sif.getSessionId().equals(sid)){
                System.out.println("found selected session");
                sif.expireNow();
                sessionRegistry.getAllSessions(AuthenticationUtils.getCurrentUser(), false).remove(sif);
                sessionRegistry.removeSessionInformation(sid);
                UserSessionStorage.removeAuthentication(AuthenticationUtils.getCurrentUser(), sid);
            }
        }
//        resp.addCookie(new Cookie("JSESSIONID",""));
        return sid;
    }
    
}
