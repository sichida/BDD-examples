package fr.ichida.example.service;

import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Recipe;
import fr.ichida.example.repository.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Unit tests for {@link RecipeService}.
 *
 * @author shoun
 * @since 12/01/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CucumberExampleApplication.class)
@Transactional
public class RecipeServiceTest {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;
    private Comparator<? super Recipe> recipeTestComparator = new Comparator<Recipe>() {
        @Override
        public int compare(Recipe o1, Recipe o2) {
            return o1.getName().equals(o2.getName()) &&
                    o1.getDescription().equals(o2.getDescription()) &&
                    o1.getMark().equals(o2.getMark()) ? 0 : 1;
        }
    };

    @Test
    public void testRegister() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setName("Cucumber salad");
        c1.setDescription("Salad with cucumber");
        c1.setMark(0.0);

        recipeService.register(c1);
        assertThat(recipeRepository.findAll()).extracting("name", "description", "mark")
                .contains(tuple(c1.getName(), c1.getDescription(), c1.getMark()));

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setName("Tomato soup");
        c2.setDescription("Soup based of tomatoes");
        c2.setMark(0.0);

        recipeService.register(c2);
        assertThat(recipeRepository.findAll()).extracting("name", "description", "mark")
                .contains(
                        tuple(c1.getName(), c1.getDescription(), c1.getMark()),
                        tuple(c2.getName(), c2.getDescription(), c2.getMark()));
    }

    @Test
    public void testFindBySpeaker() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setName("Cucumber salad");
        c1.setDescription("Salad with cucumber");
        c1.setMark(0.0);

        recipeService.register(c1);

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setName("Tomato soup");
        c2.setDescription("Soup based of tomatoes");
        c2.setMark(0.0);

        recipeService.register(c2);

        assertThat(recipeService.findByName("Cucumber salad")).usingComparator(recipeTestComparator).isEqualTo(c1);
        assertThat(recipeService.findByName("Tomato soup")).usingComparator(recipeTestComparator).isEqualTo(c2);
        assertThat(recipeService.findByName("Do not exist")).isNull();
    }

    @Test
    public void testAddMark() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setName("Cucumber salad");
        c1.setDescription("Salad with cucumber");
        c1.setMark(0.0);

        recipeService.register(c1);
        assertThat(recipeRepository.findAll()).extracting("name", "description", "mark")
                .contains(tuple(c1.getName(), c1.getDescription(), c1.getMark()));

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setName("Tomato soup");
        c2.setDescription("Soup based of tomatoes");
        c2.setMark(0.0);

        recipeService.register(c2);

        assertThat(recipeService.addMark("Cucumber salad", 5.0).getMark()).isEqualTo(5.0);
        assertThat(recipeService.addMark("Cucumber salad", 6.0).getMark()).isEqualTo(5.5);
        assertThat(recipeService.addMark("Cucumber salad", 7.0).getMark()).isEqualTo(6.0);
    }
}