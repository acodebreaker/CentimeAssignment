package org.centime.Assignment.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.centime.Assignment.Constants.ApplicationConstants.HELLO;


@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        logger.info("request received in hello controller" );
        return new ResponseEntity<>(HELLO, HttpStatus.OK);
    }
}

