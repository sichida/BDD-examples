package fr.ichida.example.service;

import fr.ichida.example.entity.Conference;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This service allows to manipulate {@link Conference} entities.
 * Convenience methods are proposed.
 *
 * @author shoun
 * @since 10/12/2015
 */
@Service
public class ConferenceService {
    private final Map<Integer, Conference> conferences;

    public ConferenceService() {
        this.conferences = new HashMap<>();
    }

    public Conference register(Conference conference) {
        conference.setId(this.conferences.size() + 1);
        conference.setMark(0.0);
        this.conferences.put(conference.getId(), conference);
        return conference;
    }

    public List<Conference> findAll() {
        return this.conferences.values().stream().collect(Collectors.toList());
    }

    public Conference findBySpeaker(String speaker) {
        for (Conference c : conferences.values()) {
            if (c.getSpeaker().equals(speaker))
                return c;
        }
        return null;
    }

    public Conference addMark(String speaker, double mark) {
        Conference c = findBySpeaker(speaker);
        if (null != c) {
            c.addMark(mark);
            return c;
        }
        return null;
    }

    public Map<Integer, Conference> getConferences() {
        return conferences;
    }
}
