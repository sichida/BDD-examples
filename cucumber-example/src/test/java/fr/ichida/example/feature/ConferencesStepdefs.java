package fr.ichida.example.feature;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Conference;
import fr.ichida.example.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Implementation of steps for BDD tests using Cucumber JVM.
 *
 * @author shoun
 * @since 10/12/2015
 */
@SpringApplicationConfiguration(CucumberExampleApplication.class)
public class ConferencesStepdefs {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private ConferenceRestService conferenceRestService;

    private List<Conference> existingConferences;

    @Given("^\"([^\"]*)\" is authenticated$")
    public void isAuthenticated(String username) throws Throwable {
        // Nothing
    }

    @And("^The following conferences were presented:$")
    public void theFollowingConferencesWerePresented(List<Conference> conferences) throws Throwable {
        conferences.stream().forEach(conferenceService::register);
    }

    @When("^He requests a list of all conferences$")
    public void heRequestsAListOfAllConferences() throws Throwable {
        this.existingConferences = conferenceRestService.findAll();
    }

    @Then("^He should have the following list:$")
    public void heShouldHaveTheFollowingList(List<Conference> conferences) throws Throwable {
        assertThat(this.existingConferences).containsAll(conferences);
    }
}
