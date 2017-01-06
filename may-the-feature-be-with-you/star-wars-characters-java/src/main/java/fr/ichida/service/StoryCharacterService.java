package fr.ichida.service;

import fr.ichida.domain.StoryCharacter;
import fr.ichida.repository.StoryCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by shoun on 04/01/2017.
 */
@RestController
@RequestMapping("/api/v1/character")
public class StoryCharacterService {
    private final StoryCharacterRepository storyCharacterRepository;

    @Autowired
    public StoryCharacterService(StoryCharacterRepository storyCharacterRepository) {
        this.storyCharacterRepository = storyCharacterRepository;
    }

    @RequestMapping(value = {"", "/"}, method = POST)
    @Transactional
    public StoryCharacter save(@RequestBody StoryCharacter newCharacter) {
        return storyCharacterRepository.save(newCharacter);
    }

    @Transactional(readOnly = true)
    @RequestMapping(value = {"", "/"}, method = GET)
    public List<StoryCharacter> findAll() {
        return storyCharacterRepository.findAll();
    }
}
