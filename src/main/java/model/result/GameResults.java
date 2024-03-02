package model.result;

import dto.GameResultsDto;
import dto.ParticipantName;
import dto.PrizeName;
import java.util.HashMap;
import java.util.Map;
import model.participant.Participant;
import model.prize.Prize;

public class GameResults {
    private final Map<Participant, Prize> gameResults;

    public GameResults(Map<Participant, Prize> gameResults) {
        this.gameResults = gameResults;
    }

    public GameResultsDto convertToResultDto() {
        return new GameResultsDto(this);
    }

    public Map<ParticipantName, PrizeName> convertToGameResultsDto() {
        Map<ParticipantName, PrizeName> gameResultsDto = new HashMap<>();
        for (Map.Entry<Participant, Prize> entry : gameResults.entrySet()) {
            ParticipantName participantName = entry.getKey().convertToParticipantName();
            PrizeName prizeName = entry.getValue().convertToPrizeName();
            gameResultsDto.put(participantName, prizeName);
        }
        return gameResultsDto;
    }
}
