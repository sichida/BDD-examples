package fr.ichida.example.feature;

import fr.ichida.example.entity.Conference;
import fr.ichida.example.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Conference register(@RequestBody Conference conference) {
        return conferenceService.register(conference);
    }

    @RequestMapping(path = "/{speaker}")
    public Conference findConferenceBySpeaker(@PathVariable("speaker") String speaker) {
        return conferenceService.findBySpeaker(speaker);
    }

    @RequestMapping(path = "/{speaker}/{mark}")
    public Conference mark(@PathVariable("speaker") String speaker, @PathVariable("mark") int mark) {
        return conferenceService.addMark(speaker, mark);
    }
}
