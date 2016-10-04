/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.config;

import javax.sql.DataSource;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author user
 */
public class ConfigTest {
    
    @Test
    public void testConnection(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(WebblogDataSourceConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        Assert.assertNotNull(ds);
    }
    
}