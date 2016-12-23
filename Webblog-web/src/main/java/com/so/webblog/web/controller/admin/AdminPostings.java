package com.so.webblog.web.controller.admin;

import com.so.webblog.service.PostingsService;
//import com.so.webblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPostings {
    
//    @Autowired
//    private UserService userService;
//    
    @Autowired
    private PostingsService postingsService;
    
    @RequestMapping(value = "/admin/postings", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("postings", postingsService.list());
        mv.setViewName("admin/postings/postings-list");
        return mv;
    }
    
}
