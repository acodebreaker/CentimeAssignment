package org.centime.Assignment.Clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class MessageClientImpl implements MessageClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.host.url}")
    private String baseUrl;

    private Logger logger = LoggerFactory.getLogger(MessageClientImpl.class);


    private final String MDCHeader = "X-Correlation-Id";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";

    @Override
    public String getMessage() {
        HttpHeaders headers = new HttpHeaders();
        String traceId;
        traceId= MDC.get(DEFAULT_MDC_UUID_TOKEN_KEY);
        headers.set(MDCHeader, traceId);

        logger.info("sending request to get hello with uuid " + traceId);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/hello", HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}