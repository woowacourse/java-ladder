package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<Integer> resultPositions;
    private final List<String> executionResults;
    
    public GameResult(List<Integer> resultPositions, List<String> executionResults) {
        this.resultPositions = resultPositions;
        this.executionResults = executionResults;
    }
    
    public String getOneExecutionResult(int playerIndex) {
        return executionResults.get(getResultPosition(playerIndex));
    }
    
    private Integer getResultPosition(int playerIndex) {
        return resultPositions.get(playerIndex);
    }
    
    public List<String> getAllExecutionResult() {
        return resultPositions.stream()
                .map(executionResults::get)
                .collect(Collectors.toUnmodifiableList());
    }
}
