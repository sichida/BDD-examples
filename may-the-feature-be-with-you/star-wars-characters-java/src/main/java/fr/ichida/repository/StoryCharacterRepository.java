package fr.ichida.repository;

import fr.ichida.domain.StoryCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shoun on 04/01/2017.
 */
@Repository
public interface StoryCharacterRepository extends JpaRepository<StoryCharacter, Integer> {
    StoryCharacter findByName(String identifier);
}
