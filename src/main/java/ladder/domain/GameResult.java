package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<String> executionResults;
    
    public GameResult(String executionResults, PlayerNames playerNames) {
        this(splitExecutionResults(executionResults), playerNames);
    }
    
    private GameResult(List<String> executionResults, PlayerNames playerNames) {
        validateExecutionResults(executionResults, playerNames);
        this.executionResults = executionResults;
    }
    
    private static List<String> splitExecutionResults(String executionResults) {
        return Arrays.stream(executionResults.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private void validateExecutionResults(List<String> executionResults, PlayerNames playerNames) {
        validateOutOfLength(executionResults);
        validateCount(executionResults, playerNames.getNames());
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
    
    private void validateCount(List<String> executionResults, List<String> playerNames) {
        if (executionResults.size() != playerNames.size()) {
            throw new IllegalArgumentException("실행 결과의 개수는 플레이어의 수가 같아야합니다.");
        }
    }
    
    public String getOneExecutionResult(int playerIndex, List<Integer> movedPositions) {
        return executionResults.get(getResultPosition(playerIndex, movedPositions));
    }
    
    private Integer getResultPosition(int playerIndex, List<Integer> movedPositions) {
        return movedPositions.get(playerIndex);
    }
    
    public List<String> getAllExecutionResult(List<Integer> movedPositions) {
        return movedPositions.stream()
                .map(executionResults::get)
                .collect(Collectors.toUnmodifiableList());
    }
    
    public List<String> getExecutionResults() {
        return executionResults;
    }
}
