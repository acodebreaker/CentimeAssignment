package org.centime.Assignment.Service;

import org.centime.Assignment.Model.ComicCharacter;
import org.centime.Assignment.Model.Node;
import org.centime.Assignment.Repository.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public ResponseEntity<String> getAllCharacter() {
        List<ComicCharacter> characters = null;

        try {
            characters = characterRepository.findAll();
        } catch (Exception ex) {
            logger.error("Unable to get all character in database", ex);
            return new ResponseEntity<>("Unable to get all character in database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (characters.size() == 0) {
            return new ResponseEntity<>("No data present in hibernate", HttpStatus.OK);
        }
        return new ResponseEntity<>(convertToHierarchyData(characters), HttpStatus.OK);
    }

    private String convertToHierarchyData(List<ComicCharacter> characters) {
        List<Node> nodes = new ArrayList<>();

        for (ComicCharacter character : characters)
            nodes.add(new Node(character.getName(), character.getId().toString(), character.getParentId().toString()));

        Map<String, Node> idToNodeMap = new HashMap<>();

        for (Node current : nodes) {
            idToNodeMap.put(current.getId(), current);
        }

        for (Node current : nodes) {
            String parentId = current.getParentId();

            if (!parentId.equals("0")) {
                Node parent = idToNodeMap.get(parentId);
                if (parent != null) {
                    current.setParent(parent);
                    parent.addChild(current);
                    idToNodeMap.put(parentId, parent);
                    idToNodeMap.put(current.getId(), current);
                }
            }
        }

        String responseString = "";
        for (Node node : idToNodeMap.values()) {
            if (node.getParentId() != null && node.getParentId().equals("0")) {
                responseString += node.toString();
            }
        }
        return responseString;
    }
}

