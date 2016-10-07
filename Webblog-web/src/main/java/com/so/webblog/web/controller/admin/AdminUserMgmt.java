package com.so.webblog.web.controller.admin;

import com.so.webblog.domain.User;
import com.so.webblog.service.UserRoleService;
import com.so.webblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AdminUserMgmt {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") Long id){
        User user = userService.byId(id.intValue());
//        if(user == null){
//            
//        }
        ModelAndView mv = new ModelAndView("/admin/user/user-edit");
        mv.addObject("user", user);
        mv.addObject("roles", userRoleService.list());
        return mv;
    }
}
