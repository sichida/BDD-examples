package fr.ichida.example.service;

import fr.ichida.example.entity.Recipe;
import fr.ichida.example.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This service allows to manipulate {@link Recipe} entities.
 * Convenience methods are proposed.
 *
 * @author shoun
 * @since 10/12/2015
 */
@Service
@Transactional
public class RecipeService {
    /**
     * Repository for handling recipes data
     */
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    /**
     * This method registers a recipe.
     * It stores data in database
     *
     * @param recipe The recipe to register
     * @return The registered recipe if succeed
     */
    @Transactional
    public Recipe register(Recipe recipe) {
        recipe.setMark(0.0);
        return recipeRepository.save(recipe);
    }

    /**
     * @return All existing recipes
     */
    @Transactional(readOnly = true)
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }


    /**
     * This method adds a mark to the recipe and updates the average grade.
     *
     * @param name The name of the recipe to evaluate
     * @param mark The mark to give to the conference
     * @return The updated recipe
     */
    @Transactional
    public Recipe addMark(String name, double mark) {
        Recipe recipe = findByName(name);
        if (null != recipe) {
            recipe.addMark(mark);
            return recipeRepository.save(recipe);
        }
        return null;
    }

    /**
     * This method finds a recipe based on it name
     *
     * @param recipe the name of the recipe to find
     * @return The found recipe if any, null otherwise
     */
    @Transactional(readOnly = true)
    public Recipe findByName(String recipe) {
        return recipeRepository.findByName(recipe);
    }
}
