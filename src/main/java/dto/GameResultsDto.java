package dto;

import java.util.Map;
import model.GameResults;

public record GameResultsDto(Map<ParticipantName, PrizeName> gameResults) {
    public GameResultsDto(GameResults gameResults) {
        this(gameResults.getGameResults());
    }
}
