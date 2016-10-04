package com.so.webblog.config;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@ComponentScan("com.so")
public class WebblogDataSourceConfig {
    
    @Autowired
    DatabaseProperties dbProperties;
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.so.webblog.domain" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }
    
    @Bean
    public EntityManager entityManager(@Autowired EntityManagerFactory emf){
        return emf.createEntityManager();
    }

    @Bean
    public DataSource dataSource(){
        System.out.println(dbProperties.getUsername());
        System.out.println(dbProperties.getPassword());
        System.out.println(dbProperties.getDbUrl());
        System.out.println(dbProperties.getDialect());
        System.out.println(dbProperties.getDriverClass());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbProperties.getDriverClass());
        dataSource.setUrl(dbProperties.getDbUrl());
        dataSource.setUsername( dbProperties.getUsername() );
        dataSource.setPassword( dbProperties.getPassword() );
        Properties other = new Properties();
        other.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        other.setProperty("hibernate.hbm2ddl.auto", "update");
        dataSource.setConnectionProperties(other);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
