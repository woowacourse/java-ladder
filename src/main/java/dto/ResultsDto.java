package dto;

import java.util.Map;
import model.Results;

public record ResultsDto(Map<ParticipantName, Integer> results) {
    public ResultsDto(Results results) {
        this(results.getResults());
    }
}
