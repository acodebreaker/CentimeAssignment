package org.centime.Assignment.Service;

import org.centime.Assignment.Clients.MessageClient;
import org.centime.Assignment.Model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageClient messageClient;

    private Logger logger = LoggerFactory.getLogger(MessageService.class);

    public ResponseEntity<String> getMessage(Person person) {

        if (person.getName().equals("") || person.getName() == null) {
            logger.error("first name not present in request");
            return new ResponseEntity<>("first name not present in request", HttpStatus.BAD_REQUEST);
        }

        if (person.getSurname().equals("") || person.getSurname() == null) {
            logger.error("last name not present in request");
            return new ResponseEntity<>("last name not present in request", HttpStatus.BAD_REQUEST);
        }

        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<String>(messageClient.getMessage(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Unable to get message", ex);
            return new ResponseEntity<>("failed to get message", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}