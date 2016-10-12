/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.util;

import com.so.webblog.domain.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author user
 */
public class AuthenticationUtils {
    @SuppressWarnings("PMD")
    public static boolean isAuthenticated(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        return (ctx.getAuthentication().getPrincipal() != null && 
                !(ctx.getAuthentication().getPrincipal()instanceof String));
    }
    @SuppressWarnings("PMD")
    public static User getCurrentUser(){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (user instanceof User) ? (User)user : null;
    }
}
