package org.centime.Assignment.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan("org.centime.Assignment")
public class RestConfig {

    @Bean(name = "appRestClient")
    public RestTemplate getRestClient() {
        RestTemplate restClient = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

            return execution.execute(request, body);
        }));
        return restClient;
    }
}
