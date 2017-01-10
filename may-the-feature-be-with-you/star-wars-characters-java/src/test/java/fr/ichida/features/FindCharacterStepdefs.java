package fr.ichida.features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.ichida.StarWarsCharactersApplication;
import fr.ichida.domain.StoryCharacter;
import fr.ichida.service.StoryCharacterService;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by shoun on 10/01/2017.
 */
@ContextConfiguration(classes = StarWarsCharactersApplication.class)
public class FindCharacterStepdefs {
    private StoryCharacter storyCharacter;
    @Autowired
    private StoryCharacterService storyCharacterService;

    @When("^George search the character \"([^\"]*)\"$")
    public void georgeSearchTheCharacter(String name) throws Throwable {
        storyCharacter = storyCharacterService.findByName(name);
    }

    @Then("^the character \"([^\"]*)\" should be found$")
    public void theCharacterShouldBeFound(String name) throws Throwable {
        assertThat(storyCharacter).isNotNull();
        assertThat(storyCharacter.getName()).isEqualTo(name);
    }

    @Then("^the character \"([^\"]*)\" shouldn't be found$")
    public void theCharacterShouldnTBeFound(String name) throws Throwable {
        assertThat(storyCharacter).isNull();
    }
}
