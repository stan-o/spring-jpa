/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.conf;

import com.so.webblog.domain.User;
import com.so.webblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
            http.authorizeRequests()
//                .antMatchers("/assets/*/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/home", false);			
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
            auth.authenticationProvider(daoAuthenticationProvider());
	}
        
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new PasswordEncoder() {
                private final ShaPasswordEncoder sha = new ShaPasswordEncoder();
                @Override
                public String encode(CharSequence cs) {
                    return sha.encodePassword(cs.toString(), 1);
                }

                @Override
                @SuppressWarnings("PMD")
                public boolean matches(CharSequence cs, String string) {
                    return (sha.encodePassword(cs.toString(), 1)).equals(string);
                }
            };
        }
        
        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider(){
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setPasswordEncoder(passwordEncoder());
            authProvider.setUserDetailsService(userDetailsService());
            return authProvider;
        }
        
        @Override
        public UserDetailsService userDetailsService(){
            UserDetailsService detailsService = new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
                    User user = null;
                    try{
                        user = userService.byUsername(string);
                    }catch(Exception ex){
                        System.out.println("user not found or error");
                        throw new UsernameNotFoundException("can't find user@username"+string);
                    }
                    if(user == null){
                        throw new UsernameNotFoundException("can't find user@username"+string);
                    }
                    return (UserDetails)user;
                }
            };
            return detailsService;
        }
}
