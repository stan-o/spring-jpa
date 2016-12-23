/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.elasticsearchsynctest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author user
 */
@Configuration
@EnableWebMvc
@EnableElasticsearchRepositories(basePackages = "com.so")
//@EnableJpaRepositories(basePackages = "com.so")
@ComponentScan("com.so")
public class WebConfig {
    @Bean
    public InternalResourceViewResolver SocksSSEViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }    
    
    @Value("${elasticsearch.home:/home/user/elasticsearch-2.4.1}")
    private String elasticsearchHome;

   

    @Bean
    public Client client() {
        try {
            final Path tmpDir = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "elasticsearch_data");
            
            // @formatter:off

            final Settings.Builder elasticsearchSettings =
                    Settings.settingsBuilder().put("http.enabled", "true")
                                              .put("path.data", tmpDir.toAbsolutePath().toString())
                                              .put("path.home", elasticsearchHome);
            
            return new NodeBuilder()
                    .local(true)
                    .settings(elasticsearchSettings)
                    .node()
                    .client();
            
            // @formatter:on
        } catch (final IOException ioex) {
            ioex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
