/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.conf;

//import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
//import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
//@Service
public class AuthenticationEventListener{

    @EventListener
    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        System.out.println("authentication successfull for user" + e.getAuthentication());
    }
}
