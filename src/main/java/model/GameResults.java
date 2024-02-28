package model;

import dto.GameResultsDto;
import dto.ParticipantName;
import dto.PrizeName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResults {
    private final Map<ParticipantName, PrizeName> gameResults;

    public GameResults(Ladder ladder, Participants participants, Prizes prizes) {
        this.gameResults = climbDownAll(ladder, participants, prizes);
    }

    private Map<ParticipantName, PrizeName> climbDownAll(Ladder ladder, Participants participants, Prizes prizes) {
        Map<ParticipantName, PrizeName> gameResults = new HashMap<>();
        List<ParticipantName> participantNames = participants.convertToParticipantsNames();
        List<PrizeName> prizeNames = prizes.convertToPrizesName();

        for (int i = 0; i < participants.size(); i++) {
            gameResults.put(participantNames.get(i), prizeNames.get(ladder.climbDownEach(i)));
        }
        return gameResults;
    }

    public GameResultsDto convertToResultDto() {
        return new GameResultsDto(this);
    }

    public Map<ParticipantName, PrizeName> getGameResults() {
        return gameResults;
    }
}
