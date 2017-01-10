package fr.ichida.service;

import fr.ichida.domain.CharacterExtraData;
import fr.ichida.domain.StoryCharacter;
import fr.ichida.dto.SwapiResponse;
import fr.ichida.repository.CharacterExtraDataRepository;
import fr.ichida.repository.StoryCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by shoun on 04/01/2017.
 */
@RestController
@RequestMapping("/api/v1/character")
public class StoryCharacterService {
    private static final String BDD_USER_AGENT = "Swapi-Bdd-poc";
    private final StoryCharacterRepository storyCharacterRepository;
    private final RestOperations restTemplate;
    private final CharacterExtraDataRepository characterExtraDataRepository;

    @Autowired
    public StoryCharacterService(StoryCharacterRepository storyCharacterRepository,
                                 RestOperations restTemplate,
                                 CharacterExtraDataRepository characterExtraDataRepository) {
        this.storyCharacterRepository = storyCharacterRepository;
        this.restTemplate = restTemplate;
        this.characterExtraDataRepository = characterExtraDataRepository;
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

    @RequestMapping(value = "/search", method = GET)
    public SwapiResponse findExtraData(@RequestParam("query") String query) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("query", query);

        HttpEntity<String> entity = getAppHeader();

        ResponseEntity<SwapiResponse> response = restTemplate.exchange("https://swapi.co/api/people/?search={query}",
                HttpMethod.GET, entity, SwapiResponse.class, uriVariables);
        return response.getBody();
    }

    @RequestMapping(value = "/import", method = POST)
    public StoryCharacter importData(@RequestParam("url") String swapiCharacterUrl) {
        HttpEntity<String> entity = getAppHeader();
        ResponseEntity<CharacterExtraData> response = restTemplate.exchange(swapiCharacterUrl, HttpMethod.GET, entity, CharacterExtraData.class);
        CharacterExtraData extraData = response.getBody();

        StoryCharacter character = this.storyCharacterRepository.findByName(extraData.getName());
        if (null == character) {
            character = new StoryCharacter();
            character.setName(extraData.getName());
        }
        character.setExtraData(this.characterExtraDataRepository.save(extraData));
        return this.storyCharacterRepository.save(character);
    }

    private HttpEntity<String> getAppHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", BDD_USER_AGENT);
        return new HttpEntity<String>("parameters", headers);
    }
}
