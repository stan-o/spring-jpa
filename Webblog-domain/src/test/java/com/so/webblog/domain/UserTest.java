/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.domain;

import com.so.webblog.config.WebblogDataSourceConfig;
import junit.framework.Assert;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author user
 */
public class UserTest {
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(WebblogDataSourceConfig.class);
    
//    @Test
    public void testUserSave(){
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WebblogDataSourceConfig.class);
        
        User stub = new User();
        stub.setActive(true);
        stub.setEmail("ksjdhfkjs");
        stub.setFirstname("jkhsdjhf");
        stub.setIdUserRole(1);
        stub.setLastname("lkjshdfkj");
        stub.setPassword("kljshdfjkjs");
        stub.setPhone("snhdfjkhskj");
        stub.setUsername("kjsdhfkjhskjdf");
        stub.setUserRole(new UserRole(1, "testRole"));
        System.out.println(stub);
        ctx.getBean(UserDaoImpl.class).save(stub);
    }
    
//    @Test
    public void testList(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WebblogDataSourceConfig.class);
        System.out.println(ctx.getBean(UserDaoImpl.class).list().size());
    }
    
}
