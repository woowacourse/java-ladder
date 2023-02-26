package domain;

import controller.LadderGameController;
import exception.ladder.GameEndReservedWordException;
import exception.participants.NullNameException;
import java.util.Map;

public class GameResult {

    private final Map<String, String> results;

    public GameResult(Map<String, String> results) {
        this.results = results;
    }

    public String getPrizeByName(String participantName) {
        if (participantName.equals(LadderGameController.EXIT_RESERVED_WORD)) {
            throw new GameEndReservedWordException();
        }
        if (results.containsKey(participantName)) {
            return results.get(participantName);
        }
        throw new NullNameException();
    }

    public Map<String, String> getAllResults() {
        return results;
    }
}
