package fr.ichida.example.feature;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsqu;
import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Conference;
import fr.ichida.example.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Implementation of steps for BDD tests using Cucumber JVM.
 * French language is used here.
 *
 * @author shoun
 * @since 05/01/2016
 */
@SpringApplicationConfiguration(CucumberExampleApplication.class)
public class ConférencesStepsdefs {
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private ConferenceRestService conferenceRestService;

    private Conference currentConference;

    @Etantdonné("^que \"([^\"]*)\" est authentifié$")
    public void queCharlesEstAuthentifié(String user) throws Throwable {
        // Nothing
    }

    @Et("^que les conférences suivantes ont été présentées:$")
    public void queLesConférencesSuivantesOntÉtéPrésentées(List<Conference> conferenceList) throws Throwable {
        conferenceList.forEach(conferenceService::register);
    }

    @Alors("^la conférence de \"([^\"]*)\" devrait avoir la note de (\\d+)$")
    public void laConférenceDeDevraitAvoirLaNoteDe(String user, int mark) throws Throwable {
        assertThat(conferenceRestService.findConferenceBySpeaker(user)).isNotNull();
        assertThat(conferenceRestService.findConferenceBySpeaker(user).getMark()).isEqualTo(mark);
    }

    @Lorsqu("^il attribue la note de (\\d+) la conférence de \"([^\"]*)\"$")
    public void ilAttribueLaNoteDeLaConférenceDe(int note, String orateur) throws Throwable {
        conferenceRestService.mark(orateur, note);
    }
}
