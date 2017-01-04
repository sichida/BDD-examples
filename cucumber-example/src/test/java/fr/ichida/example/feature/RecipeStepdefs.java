package fr.ichida.example.feature;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Lorsqu;
import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by shoun on 18/05/16.
 */
@SpringApplicationConfiguration(CucumberExampleApplication.class)
public class RecipeStepdefs {
    private final RecipeRestService recipeRestService;

    private List<Recipe> recipes;

    @Autowired
    public RecipeStepdefs(RecipeRestService recipeRestService) {
        this.recipeRestService = recipeRestService;
    }

    @And("^The following recipes exist:$")
    public void theFollowingRecipesExist(List<Recipe> recipes) throws Throwable {
        recipes.forEach(recipeRestService::register);
    }

    @Et("^que les recettes suivantes existent:$")
    public void queLesRecettesSuivantesExistent(List<Recipe> recettes) throws Throwable {
        theFollowingRecipesExist(recettes);
    }

    @Lorsqu("^il attribue la note de (\\d+) la recette \"([^\"]*)\"$")
    public void ilAttribueLaNoteDeLaRecette(int mark, String recipe) throws Throwable {
        recipeRestService.mark(recipe, mark);
    }

    @Alors("^la recette \"([^\"]*)\" devrait avoir la note de (\\d+)$")
    public void laRecetteDevraitAvoirLaNoteDe(String recipe, int mark) throws Throwable {
        Recipe r = recipeRestService.findByName(recipe);
        assertThat(r.getMark()).isEqualTo(mark);
    }

    @Then("^He should have the following list:$")
    public void heShouldHaveTheFollowingList(List<Recipe> recipes) throws Throwable {
        assertThat(this.recipes).extracting("name", "description", "mark").containsAll(
                recipes
                        .stream()
                        .map(r -> tuple(r.getName(), r.getDescription(), r.getMark()))
                        .collect(toList())
        );
    }

    @When("^He requests a list of all recipes$")
    public void heRequestsAListOfAllRecipes() throws Throwable {
        recipes = recipeRestService.findAll();
    }
}
