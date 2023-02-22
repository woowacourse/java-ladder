package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<Integer> resultPositions;
    private final List<String> executionResults;
    
    public GameResult(List<Integer> resultPositions, String executionResults) {
        this(resultPositions, splitExecutionResults(executionResults));
    }
    
    public GameResult(List<Integer> resultPositions, List<String> executionResults) {
        this.resultPositions = resultPositions;
        this.executionResults = executionResults;
    }
    
    private static List<String> splitExecutionResults(String executionResults) {
        return Arrays.stream(executionResults.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    public String getOneExecutionResult(int playerIndex) {
        return executionResults.get(getResultPosition(playerIndex));
    }
    
    private Integer getResultPosition(int playerIndex) {
        return resultPositions.get(playerIndex);
    }
    
    public List<String> getAllExecutionResult() {
        System.out.println(resultPositions);
        System.out.println(executionResults);
        return resultPositions.stream()
                .map(executionResults::get)
                .collect(Collectors.toUnmodifiableList());
    }
}
