package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final Players players;
    private final Ladder ladder;
    private final List<GameResult> gameResults;

    public Game(List<String> playerNames, List<String> gameResults, int height) {
        validateSameSize(playerNames, gameResults);

        this.players = new Players(playerNames);
        this.ladder = new Ladder(height, playerNames.size());
        this.gameResults = mapToGameResult(gameResults);
    }

    Game(List<String> playerNames, List<String> gameResults, Ladder ladder) {
        validateSameSize(playerNames, gameResults);

        this.players = new Players(playerNames);
        this.ladder = ladder;
        this.gameResults = mapToGameResult(gameResults);
    }

    private void validateSameSize(List<String> playerNames, List<String> gameResults) {
        if (playerNames.size() != gameResults.size()) {
            throw new IllegalArgumentException("사용자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
    }

    private List<GameResult> mapToGameResult(List<String> gameResults) {
        return gameResults.stream()
                .map(GameResult::new)
                .toList();
    }

    public Map<String, GameResult> showResultAll() {
        List<String> playersNames = players.getPlayers()
                .stream()
                .map(Player::getName)
                .toList();

        Map<String, GameResult> result = new LinkedHashMap<>();
        for (String playersName : playersNames) {
            result.put(playersName, showResult(playersName));
        }

        return result;
    }

    public GameResult showResult(String playerName) {
        int playerColumn = players.findPlayerColumn(playerName);
        int resultColumn = ladder.climb(playerColumn);

        return gameResults.get(resultColumn);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
