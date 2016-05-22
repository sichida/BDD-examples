package fr.ichida.example.repository;

import fr.ichida.example.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *
 * @author shoun
 * @since 17/01/2016
 */
@Repository("recipeRepository")
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Override
    List<Recipe> findAll();

    Recipe findByName(String name);
}
