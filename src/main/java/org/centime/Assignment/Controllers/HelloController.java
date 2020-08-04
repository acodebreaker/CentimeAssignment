package org.centime.Assignment.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.centime.Assignment.Constants.ApplicationConstants.HELLO;


@Controller
public class HelloController {

@RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>( HELLO ,HttpStatus.OK);
    }
}

