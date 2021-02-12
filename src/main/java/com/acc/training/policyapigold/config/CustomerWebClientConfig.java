package com.acc.training.policyapigold.config;

import com.acc.training.policyapigold.configproperties.CustomerServiceClientConfigProps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CustomerWebClientConfig {
    
    @Autowired
    private CustomerServiceClientConfigProps customerServiceClientConfigProps;

    @Bean
    public WebClient customerWebClient(){
        return WebClient.builder().baseUrl(customerServiceClientConfigProps.getUri()).defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
    }
}
