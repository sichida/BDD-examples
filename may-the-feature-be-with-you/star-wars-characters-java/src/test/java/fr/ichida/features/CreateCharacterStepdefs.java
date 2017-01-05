package fr.ichida.features;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @When("^George creates \"([^\"]*)\" \"([^\"]*)\" portrayed by \"([^\"]*)\"$")
    public void georgeCreatesPortrayedBy(String firstname, String lastname, String actor) throws Throwable {
        StoryCharacter newCharacter = new StoryCharacter();
        newCharacter.setFirstname(firstname);
        newCharacter.setLastname(lastname);
        newCharacter.setActor(actor);
        storyCharacterService.save(newCharacter);
    }

    @Then("^the character \"([^\"]*)\" \"([^\"]*)\" should exist$")
    public void theCharacterShouldExist(String firstname, String lastname) throws Throwable {
        StoryCharacter character = storyCharacterRepository.findByFirstnameAndLastname(firstname, lastname);
        assertThat(character).isNotNull();
    }

    @When("^George creates the following character:$")
    public void georgeCreatesTheFollowingCharacter(List<StoryCharacter> character) throws Throwable {
        try {
            storyCharacterService.save(character.get(0));
        } catch (Exception any) {
            this.exceptionHasBeenRaised = true;
        }
    }

    @And("^the character \"([^\"]*)\" \"([^\"]*)\" should be interpreted by \"([^\"]*)\"$")
    public void theCharacterShouldBeInterpretedBy(String firstname, String lastname, String actor) throws Throwable {
        StoryCharacter character = storyCharacterRepository.findByFirstnameAndLastname(firstname, lastname);
        assertThat(character.getActor()).isEqualTo(actor);
    }

    @And("^the character \"([^\"]*)\" \"([^\"]*)\" should have a picture$")
    public void theCharacterShouldHaveAPicture(String firstname, String lastname) throws Throwable {
        StoryCharacter character = storyCharacterRepository.findByFirstnameAndLastname(firstname, lastname);
        assertThat(character.getImageUrl()).isNotEmpty();
    }

    @Given("^the following characters exist:$")
    public void theFollowingCharactersExist(List<StoryCharacter> character) throws Throwable {
        character.forEach(storyCharacterRepository::save);
    }

    @Then("^an error should have been raised$")
    public void anErrorShouldHaveBeenRaised() throws Throwable {
        assertThat(this.exceptionHasBeenRaised).isTrue();
    }
}
