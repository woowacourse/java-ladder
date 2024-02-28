package laddergame.model;

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
