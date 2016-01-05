package fr.ichida.example.feature;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsqu;
import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Conference;
import fr.ichida.example.service.ConferenceService;
import org.assertj.core.api.AssertionsForClassTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

/**
 * <p>
 *
 * @author shoun
 * @since 05/01/2016
 */
@SpringApplicationConfiguration(CucumberExampleApplication.class)
public class ConférenceStepsdefs {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private ConferenceRestService conferenceRestService;

    private Conference currentConference;

    @Etantdonné("^que Charles est authentifié$")
    public void queCharlesEstAuthentifié() throws Throwable {
        // Nothing
    }

    @Et("^que les conférences suivantes ont été présentées:$")
    public void queLesConférencesSuivantesOntÉtéPrésentées(List<Conference> conferences) throws Throwable {
        conferences.stream().forEach(conferenceService::register);
    }

    @Lorsqu("^il sélectionne la conférence de \"([^\"]*)\"$")
    public void ilSélectionneLaConférence(String speaker) throws Throwable {
        currentConference = conferenceRestService.findBySpeaker(speaker);
    }

    @Et("^qu'il attribue la note de (\\d+)$")
    public void quIlAttribueLaNoteDe(int mark) throws Throwable {
        conferenceRestService.addMark(currentConference.getId(), new Integer(mark).doubleValue());
    }

    @Alors("^la conférence de \"([^\"]*)\" devrait avoir la note de (\\d+)$")
    public void laConférenceDevraitAvoirLaNoteDe(String speaker, int mark) throws Throwable {
        AssertionsForClassTypes.assertThat(conferenceRestService.findBySpeaker(speaker).getMark()).isEqualTo(mark);
    }
}
