package org.centime.Assignment.Service;

import org.centime.Assignment.Clients.MessageClient;
import org.centime.Assignment.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    @Autowired
    MessageClient messageClient;

    public ResponseEntity<String> getMessage(Person person){

        ResponseEntity<String> responseEntity= new ResponseEntity<String>( messageClient.getMessage(),HttpStatus.OK);
        return responseEntity;
        }



}
