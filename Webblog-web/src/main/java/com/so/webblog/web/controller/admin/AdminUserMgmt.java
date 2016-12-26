package com.so.webblog.web.controller.admin;

import com.so.webblog.domain.User;
import com.so.webblog.service.UserRolesService;
import com.so.webblog.service.UserService;
import com.so.webblog.web.controller.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
@Transactional
public class AdminUserMgmt {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @SuppressWarnings("PMD")
    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") Integer id) {
        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<SessionInformation> sessionInformation = sessionRegistry.getAllSessions(current, true);
        for (SessionInformation info : sessionInformation) {
            System.out.println(info);
        }
        for (Object principal : principals) {
            System.out.println(principal);
        }
        User user = null;
        ModelAndView mv = new ModelAndView("/admin/user/user-edit");
        if (id != 0) {
            user = userService.byId(id);
            mv.addObject("user", user);
            if (user == null) {
                throw new UserNotFoundException();
            }
        }else{
            throw new UserNotFoundException("no such user found");
        }
        mv.addObject("roles", userRolesService.byUserId(user.getId()));
        return mv;
    }

}
