package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dto.ParticipantName;

public class LadderGame {
    private final Ladder ladder;
    private final ExecutionResult executionResult;
    private final Map<String, String> prize;

    public LadderGame(Ladder ladder, ExecutionResult executionResult) {
        this.ladder = ladder;
        this.executionResult = executionResult;
        this.prize = new HashMap<>();
    }

    public void gameStart(List<ParticipantName> participantNames) {
        for (int i = 0; i < participantNames.size(); i++) {
            int positionResult = ladder.move(i);
            String result = executionResult.getExecutionResult().get(positionResult);
            prize.put(participantNames.get(i).name(), result);
        }
    }

    public Map<String, String> getPrize() {
        return prize;
    }
}
