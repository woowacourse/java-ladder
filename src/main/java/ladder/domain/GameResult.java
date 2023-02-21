package ladder.domain;

import java.util.List;

public class GameResult {
    private final List<Integer> resultPositions;
    private final List<String> executionResults;
    
    public GameResult(List<Integer> resultPositions, List<String> executionResults) {
        this.resultPositions = resultPositions;
        this.executionResults = executionResults;
    }
    
    public String getExecutionResult(int playerIndex) {
        return executionResults.get(getResultPosition(playerIndex));
    }
    
    private Integer getResultPosition(int playerIndex) {
        return resultPositions.get(playerIndex);
    }
}
