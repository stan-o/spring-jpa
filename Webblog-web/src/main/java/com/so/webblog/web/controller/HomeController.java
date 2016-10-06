/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = {"/","/home"})
    public String home(){
        return "index";
    }
    @RequestMapping(value = {"/login"})
    public String login(){
        return "login";
    }
    
}
