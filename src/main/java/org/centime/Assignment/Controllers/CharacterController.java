package org.centime.Assignment.Controllers;

import org.centime.Assignment.Model.ComicCharacter;
import org.centime.Assignment.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/character/{id}")
    public ResponseEntity<String> getCharacterById(@PathVariable String id) {


        return null;
    }

    @GetMapping("/comicCharacter")
    public ResponseEntity<List<ComicCharacter>> getAllCharacters() {
        return characterService.getAllCharacter();
    }

    @PostMapping("/comicCharacter")
    public ResponseEntity<String> saveCharacter(@RequestBody ComicCharacter comicCharacter) {
        return characterService.saveCharacter(comicCharacter);
    }


}

