package fr.ichida.example.feature;

import fr.ichida.example.entity.Recipe;
import fr.ichida.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the REST API for {@link Recipe} entities.
 * Root path is <i>/conference</i>.
 *
 * @author shoun
 * @since 10/12/2015
 */
@RestController
@RequestMapping("/conference")
public class RecipeRestService {

    private final RecipeService conferenceService;

    @Autowired
    public RecipeRestService(RecipeService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @RequestMapping(path = {"", "/"})
    public List<Recipe> findAll() {
        return conferenceService.findAll();
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Recipe register(@RequestBody Recipe conference) {
        return conferenceService.register(conference);
    }

//    @RequestMapping(path = "/{speaker}")
//    public Recipe findConferenceBySpeaker(@PathVariable("speaker") String speaker) {
//        return conferenceService.findBySpeaker(speaker);
//    }
//
//    @RequestMapping(path = "/{speaker}/{mark}")
//    public Recipe mark(@PathVariable("speaker") String speaker, @PathVariable("mark") int mark) {
//        return conferenceService.addMark(speaker, mark);
//    }
}
