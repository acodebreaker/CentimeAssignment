package org.centime.Assignment.Repository;

import org.centime.Assignment.Model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,Integer> {

}
