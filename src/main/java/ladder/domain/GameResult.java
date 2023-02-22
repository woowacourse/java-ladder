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
        validateExecutionResults(executionResults, resultPositions);
        this.resultPositions = resultPositions;
        this.executionResults = executionResults;
    }
    
    private static List<String> splitExecutionResults(String executionResults) {
        return Arrays.stream(executionResults.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private void validateExecutionResults(List<String> executionResults, List<Integer> resultPositions) {
        validateOutOfLength(executionResults);
        validateCount(executionResults, resultPositions);
    }
    
    private void validateOutOfLength(List<String> executionResults) {
        if (isOutOfLength(executionResults)) {
            throw new IllegalArgumentException("각 상품의 글자 길이는 1~5입니다.");
        }
    }
    
    private boolean isOutOfLength(List<String> executionResults) {
        return executionResults.stream()
                .map(String::length)
                .anyMatch(executionResultLength -> executionResultLength < 1 || executionResultLength > 5);
    }
    
    private void validateCount(List<String> executionResults, List<Integer> resultPositions) {
        if (executionResults.size() != resultPositions.size()) {
            throw new IllegalArgumentException("실행 결과의 개수는 플레이어의 수가 같아야합니다.");
        }
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
    
    public List<String> getExecutionResults() {
        return executionResults;
    }
}
