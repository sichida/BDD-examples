package fr.ichida.example.service;

import fr.ichida.example.entity.Conference;
import fr.ichida.example.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This service allows to manipulate {@link Conference} entities.
 * Convenience methods are proposed.
 *
 * @author shoun
 * @since 10/12/2015
 */
@Service
@Transactional
public class ConferenceService {
    /**
     * Repository for handling conference data
     */
    private final ConferenceRepository conferencesRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferencesRepository) {
        this.conferencesRepository = conferencesRepository;
    }

    /**
     * This method registers a conference.
     * It stores data in database
     *
     * @param conference The conference to register
     * @return The registered conference if succeed
     */
    public Conference register(Conference conference) {
        return conferencesRepository.save(conference);
    }

    /**
     * @return All existing conferences
     */
    @Transactional(readOnly = true)
    public List<Conference> findAll() {
        return conferencesRepository.findAll();
    }

    /**
     * This method finds a conference by the name of it speaker
     *
     * @param speaker The spearker of the conference to find
     * @return Found conference if any, null otherwise
     */
    @Transactional(readOnly = true)
    public Conference findBySpeaker(String speaker) {
        return conferencesRepository.findBySpeaker(speaker);
    }

    /**
     * This method adds a mark to the conference and updates the average grade.
     *
     * @param speaker The speaker of the conference to evaluate
     * @param mark    The mark to give to the conference
     * @return The updated conference
     */
    public Conference addMark(String speaker, double mark) {
        Conference c = findBySpeaker(speaker);
        if (null != c) {
            c.addMark(mark);
            return conferencesRepository.save(c);
        }
        return null;
    }
}
