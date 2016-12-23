/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.elasticsearchsynctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class IndexController{
    
    @Autowired
    UserRepositoryImpl userRepository;

    @RequestMapping(value = {"/","index"})
    public ModelAndView getPageIndexed(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("users", userRepository.findAll());
        return mv;
    }
    
}
