package fr.ichida.example.repository;

import fr.ichida.example.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *
 * @author shoun
 * @since 17/01/2016
 */
@Repository("conferenceRepository")
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    @Override
    List<Recipe> findAll();

    Recipe findBySpeaker(String speaker);
}
