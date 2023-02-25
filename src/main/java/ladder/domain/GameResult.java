package ladder.domain;

public class GameResult {
    private static final int MIN_EXECUTION_RESULT_LENGTH = 1;
    private static final int MAX_EXECUTION_RESULT_LENGTH = 5;
    
    private final String gameResult;
    
    public GameResult(String gameResult) {
        validateOutOfLength(gameResult);
        this.gameResult = gameResult;
    }
    
    private void validateOutOfLength(String gameResult) {
        if (isExecutionResultOutOfLength(gameResult)) {
            throw new IllegalArgumentException("각 상품의 글자 길이는 1~5입니다.");
        }
    }
    
    private boolean isExecutionResultOutOfLength(String gameResult) {
        return gameResult.length() < MIN_EXECUTION_RESULT_LENGTH || gameResult.length() > MAX_EXECUTION_RESULT_LENGTH;
    }
    
    public int length() {
        return gameResult.length();
    }
    
    public String getGameResult() {
        return gameResult;
    }
}
