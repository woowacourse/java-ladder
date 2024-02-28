package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final Players players;
    private final Ladder ladder;
    private final List<GameResult> gameResults;

    public Game(Players players, Ladder ladder, List<GameResult> gameResults) {
        validateSameSize(players, gameResults);

        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    private void validateSameSize(Players players, List<GameResult> gameResults) {
        if (players.size() != gameResults.size()) {
            throw new IllegalArgumentException("사용자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
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
