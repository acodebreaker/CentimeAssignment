package org.centime.Assignment.Service;

import org.centime.Assignment.Model.ComicCharacter;
import org.centime.Assignment.Repository.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {


    @Autowired
    private CharacterRepository characterRepository;
    Logger logger = LoggerFactory.getLogger(CharacterRepository.class);

    public ResponseEntity<String> saveCharacter(ComicCharacter comicCharacter) {
        try {
            characterRepository.save(comicCharacter);
        } catch (Exception ex) {
            logger.error("Unable to save character in database", ex);
            return new ResponseEntity<>("Request failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Request passed", HttpStatus.OK);

    }


    public ResponseEntity<List<ComicCharacter>> getAllCharacter() {
        try {
            return new ResponseEntity<>(characterRepository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Unable to get all character in database", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
