package fr.ichida.example.repository;

import fr.ichida.example.entity.Conference;
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
public interface ConferenceRepository extends CrudRepository<Conference, Integer> {

    @Override
    List<Conference> findAll();

    Conference findBySpeaker(String speaker);
}
