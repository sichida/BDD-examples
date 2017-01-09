package fr.ichida.dto;

import fr.ichida.domain.CharacterExtraData;

import java.util.List;

/**
 * Created by shoun on 08/01/2017.
 */
public class SwapiResponse {

    private Integer count;
    private List<CharacterExtraData> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CharacterExtraData> getResults() {
        return results;
    }

    public void setResults(List<CharacterExtraData> results) {
        this.results = results;
    }
}
