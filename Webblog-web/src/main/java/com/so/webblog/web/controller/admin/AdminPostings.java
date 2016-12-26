package com.so.webblog.web.controller.admin;

import com.so.webblog.domain.Postings;
import com.so.webblog.domain.User;
import com.so.webblog.service.PostingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPostings {
    
//    @Autowired
//    private UserService userService;
//    
    @Autowired
    private PostingsService postingsService;
    
    @RequestMapping(value = "/admin/postings", method = RequestMethod.GET)
    @Transactional
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("postings", postingsService.list());
        mv.setViewName("admin/postings/postings-list");
        return mv;
    }
    
    @RequestMapping(value = "/admin/postings/new", method = RequestMethod.GET)
    public String newPosting(){
        return "admin/postings/new-post";
    }
    
    @RequestMapping(value = "/admin/postings/new", method = RequestMethod.POST)
    public String saveNewPost(@RequestParam("title") String title, @RequestParam("editor") String resource){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Postings post = new Postings();
        post.setUser(user);
        post.setTitle(title);
        post.setResource(resource);
        postingsService.save(post);
        return "redirect:/admin/postings";
    }
    
}
