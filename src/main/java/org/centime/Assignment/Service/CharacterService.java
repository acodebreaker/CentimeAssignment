package org.centime.Assignment.Service;

import org.centime.Assignment.Model.Character;
import org.centime.Assignment.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {


    @Autowired
    CharacterRepository characterRepository;

    public ResponseEntity<String> saveCharacter(Character character) {
        try {
            characterRepository.save(character);
        } catch (Exception ex) {

            return new ResponseEntity<>("Request failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Request failed", HttpStatus.OK);


    }
}
