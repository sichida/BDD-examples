package fr.ichida.features;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Lorsque;
import fr.ichida.StarWarsCharactersApplication;
import fr.ichida.domain.StoryCharacter;
import fr.ichida.service.StoryCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by shoun on 06/01/2017.
 */
@ContextConfiguration(classes = StarWarsCharactersApplication.class)
public class ListCharactersStepdefs {
    private List<StoryCharacter> storyCharacters;
    @Autowired
    private StoryCharacterService storyCharacterService;

    @Lorsque("^je demande tous les personnages existants$")
    public void jeDemandeTousLesPersonnagesExistants() throws Throwable {
        this.storyCharacters = storyCharacterService.findAll();
    }

    @Alors("^je dois avoir (\\d+) personnage.*$")
    public void jeDoisAvoirPersonnage(int nbCharacter) throws Throwable {
        assertThat(this.storyCharacters.size()).isEqualTo(nbCharacter);
    }

    @Et("^je dois avoir le personnage suivant parmis les résultats :$")
    public void jeDoisAvoirLePersonnageSuivantParmisLesRésultats(List<StoryCharacter> character) throws Throwable {
        StoryCharacter sc = character.get(0);
        assertThat(this.storyCharacters).extracting("name", "actor", "description", "imageUrl")
                .contains(tuple(sc.getName(), sc.getActor(), sc.getDescription(), sc.getImageUrl()));
    }
}
