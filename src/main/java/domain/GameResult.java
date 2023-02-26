package domain;

import controller.LadderGameController;
import domain.ladder.LadderPrize;
import domain.participants.Participant;
import exception.ladder.GameEndReservedWordException;
import exception.participants.NullNameException;
import java.util.Map;

public class GameResult {

    private final Map<Participant, LadderPrize> results;

    public GameResult(Map<Participant, LadderPrize> results) {
        this.results = results;
    }

    public LadderPrize getPrizeByName(String participantName) {
        if (participantName.equals(LadderGameController.EXIT_RESERVED_WORD)) {
            throw new GameEndReservedWordException();
        }
        Participant findParticipant = new Participant(participantName);
        if (results.containsKey(findParticipant)) {
            return results.get(findParticipant);
        }
        throw new NullNameException();
    }

    public Map<Participant, LadderPrize> getAllResults() {
        return results;
    }
}
