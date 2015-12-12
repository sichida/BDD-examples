package fr.ichida.example.service;

import fr.ichida.example.entity.Conference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service allows to manipulate {@link Conference} entities.
 * Convenience methods are proposed.
 *
 * @author shoun
 * @since 10/12/2015
 */
@Service
public class ConferenceService {
    private final List<Conference> conferences;

    public ConferenceService() {
        this.conferences = new ArrayList<>();
    }

    public Conference register(Conference conference) {
        return this.conferences.add(conference) ? conference : null;
    }

    public List<Conference> findAll() {
        return this.conferences;
    }
}
