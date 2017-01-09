package fr.ichida.features;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.ichida.StarWarsCharactersApplication;
import fr.ichida.domain.CharacterExtraData;
import fr.ichida.domain.StoryCharacter;
import fr.ichida.dto.SwapiResponse;
import fr.ichida.repository.StoryCharacterRepository;
import fr.ichida.service.StoryCharacterService;
import org.assertj.core.groups.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by shoun on 08/01/2017.
 */
@ContextConfiguration(classes = StarWarsCharactersApplication.class)
public class ImportStepdefs {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StoryCharacterService storyCharacterService;
    @Autowired
    private StoryCharacterRepository storyCharacterRepository;


    MockRestServiceServer server;
    private SwapiResponse swapiResponse;

    @Before
    public void setUp() {
        server = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Given("^Star Wars API responds \"([^\"]*)\" when searching for \"([^\"]*)\"$")
    public void starWarsAPIRespondsWhenSearchingFor(String stubDataFile, String query) throws Throwable {
        InputStream stream = new ClassPathResource(stubDataFile).getInputStream();
        server.expect(requestTo("https://swapi.co/api/people/?search=Kenobi"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(StreamUtils.copyToByteArray(stream), MediaType.APPLICATION_JSON));
    }

    @And("^Star Wars API responds \"([^\"]*)\" when importing data from \"([^\"]*)\"$")
    public void starWarsAPIRespondsWhenImportingDataFrom(String stubDataFile, String url) throws Throwable {
        InputStream stream = new ClassPathResource(stubDataFile).getInputStream();
        server.expect(requestTo(url))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(StreamUtils.copyToByteArray(stream), MediaType.APPLICATION_JSON));
    }

    @When("^I look for data for the query \"([^\"]*)\"$")
    public void iLookForDataForTheQuery(String query) throws Throwable {
        swapiResponse = storyCharacterService.findExtraData(query);
    }

    @Then("^Star Wars API should have answered$")
    public void starWarsAPIShouldHaveAnswered() throws Throwable {
        server.verify();
    }

    @And("^I should have (\\d+) result in response$")
    public void iShouldHaveResultInResponse(int nbResult) throws Throwable {
        assertThat(swapiResponse.getCount()).isEqualTo(nbResult);
    }

    @When("^I import data for selected item$")
    public void iImportDataForSelectedItem() throws Throwable {
        storyCharacterService.importData(swapiResponse.getResults().get(0).getUrl());
    }

    @And("^the character \"([^\"]*)\" should have extra data:$")
    public void theCharacterShouldHaveExtraData(String identifier, List<CharacterExtraData> refExtraData) throws Throwable {
        StoryCharacter character = storyCharacterRepository.findByName(identifier);
        CharacterExtraData extraData = character.getExtraData();
        Tuple dataToTest = tuple(extraData.getGender(), extraData.getHeight(), extraData.getMass(), extraData.getHairColor(),
                extraData.getSkinColor(), extraData.getEyeColor(), extraData.getBirthYear());
        CharacterExtraData ref = refExtraData.get(0);
        Tuple refData = tuple(ref.getGender(), ref.getHeight(), ref.getMass(), ref.getHairColor(),
                ref.getSkinColor(), ref.getEyeColor(), ref.getBirthYear());
        assertThat(dataToTest).isEqualTo(refData);

    }

    @Given("^I prepare new calls to SWAPI$")
    public void iPrepareNewCallsToSWAPI() throws Throwable {
        server.reset();
    }
}
