package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {
    private static final String COMMA_DELIMITER = ",";
    
    private final List<GameResult> gameResults;
    
    public GameResults(String gameResults, PlayerNames playerNames) {
        this(splitGameResults(gameResults), playerNames);
    }
    
    private GameResults(List<GameResult> gameResults, PlayerNames playerNames) {
        validateCount(gameResults, playerNames.getNames());
        this.gameResults = gameResults;
    }
    
    private static List<GameResult> splitGameResults(String gameResults) {
        return Arrays.stream(gameResults.split(COMMA_DELIMITER))
                .map(GameResult::new)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private void validateCount(List<GameResult> gameResults, List<String> playerNames) {
        if (gameResults.size() != playerNames.size()) {
            throw new IllegalArgumentException("실행 결과의 개수는 플레이어의 수가 같아야합니다.");
        }
    }
    
    public GameResult getGameResult(int playerIndex, List<Integer> movedPositions) {
        return gameResults.get(getResultPosition(playerIndex, movedPositions));
    }
    
    private Integer getResultPosition(int playerIndex, List<Integer> movedPositions) {
        return movedPositions.get(playerIndex);
    }
    
    public List<GameResult> getSortedGameResults(List<Integer> movedPositions) {
        return movedPositions.stream()
                .map(gameResults::get)
                .collect(Collectors.toUnmodifiableList());
    }
    
    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
