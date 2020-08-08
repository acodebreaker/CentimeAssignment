package org.centime.Assignment.Controllers;

import org.centime.Assignment.Model.Person;
import org.centime.Assignment.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<String> message(@RequestBody Person person) {

        ResponseEntity<String> response = messageService.getMessage(person);
        String responseString = response.getBody();
        responseString = responseString + " " + person.getName() + " " + person.getSurname();
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }
}
