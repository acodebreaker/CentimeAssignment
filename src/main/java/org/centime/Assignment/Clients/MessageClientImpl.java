package org.centime.Assignment.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageClientImpl implements MessageClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.host.url}")
    private String baseUrl;

    @Override
    public String getMessage() {

        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/hello", String.class);
        return response.getBody();
    }
}
