package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
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
        IntStream.range(0, participantNames.size()).forEach(position -> {
            int positionResult = ladder.move(position);
            String result = executionResult.getExecutionResult().get(positionResult);
            prize.put(participantNames.get(position).name(), result);
        });
    }

    public Map<String, String> getPrize() {
        return prize;
    }
}
