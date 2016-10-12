/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.web.controller.admin;

import com.so.webblog.info.UserSessionStorage;
import com.so.webblog.util.AuthenticationUtils;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AdminSessionsInfo {
    
    @RequestMapping(value = {"/admin/sessions"}, method = RequestMethod.GET)
    public ModelAndView getAllSessions(){
        ModelAndView mv = new ModelAndView("admin/sessions/sessions-list");
        Map activeSessions = UserSessionStorage.getAllUserOrigins(AuthenticationUtils.getCurrentUser());
        mv.addObject("sessions", activeSessions.keySet().toArray());
        mv.addObject("sessionsInfo", activeSessions.values().toArray());
        mv.addObject("len", activeSessions.values().toArray().length);
        return mv;
    }
    
}
