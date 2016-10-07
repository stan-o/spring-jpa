/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.web.controller.admin;

import com.so.webblog.service.UserRoleNameService;
import com.so.webblog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AdminSecurityGroups {
    
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserRoleNameService userRoleNameService;
    
    @RequestMapping(value = "/admin/groups")
    public ModelAndView getSecurityGroups(){
        ModelAndView mv = new ModelAndView("admin/security-groups/groups-list");
        mv.addObject("groups", userRoleService.list());
        return mv;
    }
}
