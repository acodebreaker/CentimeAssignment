package org.centime.Assignment.Controllers;

import org.centime.Assignment.Model.Character;
import org.centime.Assignment.Model.Person;
import org.centime.Assignment.Requests.CharacterRequest;
import org.centime.Assignment.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @RequestMapping("/character/{id}")
    public ResponseEntity<String> getCharacterById(@PathVariable String id) {


    return null;
    }

    @RequestMapping("/characters")
    public ResponseEntity<String> getAllCharacters(@PathVariable String id) {


        return null;

    }

    @PostMapping("/character")
    public ResponseEntity<String> saveCharacter(@RequestBody Character character) {
       return characterService.saveCharacter(character);
    }





}

