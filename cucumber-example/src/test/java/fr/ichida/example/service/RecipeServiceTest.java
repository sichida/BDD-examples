package fr.ichida.example.service;

import fr.ichida.example.CucumberExampleApplication;
import fr.ichida.example.entity.Recipe;
import fr.ichida.example.repository.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

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
    private RecipeRepository conferencesRepository;
    @Autowired
    private RecipeService conferenceService;

    @Test
    public void testRegister() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        conferenceService.register(c1);
        assertThat(conferencesRepository.findAll()).containsOnly(c1);

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c2);
        assertThat(conferencesRepository.findAll()).containsOnly(c1, c2);
    }

    @Test
    public void testFindAll() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);
        assertThat(conferenceService.findAll()).containsOnly(c1, c2);
    }

    @Test
    public void testFindBySpeaker() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);
        assertThat(conferenceService.findBySpeaker("Speaker 1")).isEqualTo(c1);
        assertThat(conferenceService.findBySpeaker("Speaker 2")).isEqualTo(c2);
        assertThat(conferenceService.findBySpeaker("Do not exist")).isNull();
    }

    @Test
    public void testAddMark() throws Exception {
        Recipe c1 = new Recipe();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Recipe c2 = new Recipe();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);

        assertThat(conferenceService.addMark("Speaker 1", 5.0).getMark()).isEqualTo(5.0);
        assertThat(conferenceService.addMark("Speaker 1", 6.0).getMark()).isEqualTo(5.5);
        assertThat(conferenceService.addMark("Speaker 1", 7.0).getMark()).isEqualTo(6.0);
    }
}