package fr.ichida.features;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.fr.Etantdonné;
import fr.ichida.StarWarsCharactersApplication;
import fr.ichida.domain.StoryCharacter;
import fr.ichida.repository.StoryCharacterRepository;
import fr.ichida.service.StoryCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by shoun on 04/01/2017.
 */
@ContextConfiguration(classes = StarWarsCharactersApplication.class)
public class CreateCharacterStepdefs {
    @Autowired
    private StoryCharacterService storyCharacterService;
    @Autowired
    private StoryCharacterRepository storyCharacterRepository;
    private boolean exceptionHasBeenRaised;

    @Before
    public void beforeScenario() {
        this.exceptionHasBeenRaised = false;
    }

    @When("^George edits the character \"([^\"]*)\" with the following data:$")
    public void georgeEditsTheCharacterWithTheFollowingData(String name, List<StoryCharacter> characters) throws Throwable {
        try {
            storyCharacterService.edit(name, characters.get(0));
        } catch (Exception e) {
            this.exceptionHasBeenRaised = true;
        }
    }
}
