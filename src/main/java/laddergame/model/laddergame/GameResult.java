package laddergame.model.laddergame;

import laddergame.model.executionresults.ExecutionResult;
import laddergame.model.participants.Participant;

public class GameResult {
    private final Participant participant;
    private final ExecutionResult executionResult;

    public GameResult(Participant participant, ExecutionResult executionResult) {
        this.participant = participant;
        this.executionResult = executionResult;
    }

    public Participant getParticipant() {
        return participant;
    }

    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
}
