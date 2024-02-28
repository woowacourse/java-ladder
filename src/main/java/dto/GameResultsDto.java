package dto;

import java.util.Map;
import model.GameResults;

public record GameResultsDto(Map<ParticipantName, PrizeName> gameResults) {
    public GameResultsDto(GameResults gameResults) {
        this(gameResults.convertToGameResultsDto());
    }

    public PrizeName getPrizeNameByParticipantName(ParticipantName participantName) {
        return this.gameResults.get(participantName);
    }
}
