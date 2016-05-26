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

    private final RecipeService recipeService;

    @Autowired
    public RecipeRestService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Recipe register(@RequestBody Recipe conference) {
        return recipeService.register(conference);
    }

    @RequestMapping(path = "/{speaker}")
    public Recipe findByName(@PathVariable("recipe") String recipe) {
        return recipeService.findByName(recipe);
    }

    @RequestMapping(path = "/{speaker}/{mark}")
    public Recipe mark(@PathVariable("receipe") String recipe, @PathVariable("mark") int mark) {
        return recipeService.addMark(recipe, mark);
    }

    @RequestMapping(path = {"", "/"})
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }
}
