package fr.ichida.example.feature;

import fr.ichida.example.entity.Conference;
import fr.ichida.example.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class represents the REST API for {@link Conference} entities.
 * Root path is <i>/conference</i>.
 *
 * @author shoun
 * @since 10/12/2015
 */
@RestController
@RequestMapping("/conference")
public class ConferenceRestService {

    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceRestService(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @RequestMapping(path = {"", "/"})
    public List<Conference> findAll() {
        return conferenceService.findAll();
    }

    public Conference findBySpeaker(String speaker) {
        return conferenceService.findBySpeaker(speaker);
    }

    public Conference addMark(Integer conferenceId, double mark) {
        return conferenceService.addMark(conferenceId, mark);
    }
}
