package org.centime.Assignment.Service;

import org.centime.Assignment.Model.ComicCharacter;
import org.centime.Assignment.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {


    @Autowired
    private CharacterRepository characterRepository;

    public ResponseEntity<String> saveCharacter(ComicCharacter comicCharacter) {
        try {
            characterRepository.save(comicCharacter);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return new ResponseEntity<>("Request failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Request passed", HttpStatus.OK);

    }
}
