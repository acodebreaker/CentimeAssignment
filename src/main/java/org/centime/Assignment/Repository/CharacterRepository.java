package org.centime.Assignment.Repository;

import org.centime.Assignment.Model.ComicCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<ComicCharacter, Integer> {


}
