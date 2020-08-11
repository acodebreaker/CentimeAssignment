package org.centime.Assignment.Controllers;

import org.centime.Assignment.Model.ComicCharacter;
import org.centime.Assignment.Repository.CharacterRepository;
import org.centime.Assignment.Service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    private Logger logger = LoggerFactory.getLogger(CharacterRepository.class);

    @GetMapping("/comicCharacter")
    public ResponseEntity<String> getAllCharacters() {
        return characterService.getAllCharacter();
    }

    @PostMapping("/comicCharacter")
    public ResponseEntity<String> saveCharacter(@RequestBody ComicCharacter comicCharacter) {
        logger.info("Request Received for adding character" + comicCharacter);
        return characterService.saveCharacter(comicCharacter);
    }
}

