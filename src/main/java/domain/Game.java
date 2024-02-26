package domain;

import java.util.List;

public class Game {

    private final Players players;
    private final Ladder ladder;
    private final List<GameResult> gameResults;

    public Game(List<String> playerNames, List<String> gameResults, int height) {
        validateSameSize(playerNames, gameResults);

        this.players = new Players(playerNames);
        this.ladder = new Ladder(height, playerNames.size());
        this.gameResults = gameResults.stream()
                .map(GameResult::new)
                .toList();
    }

    private void validateSameSize(List<String> playerNames, List<String> gameResults) {
        if (playerNames.size() != gameResults.size()) {
            throw new IllegalArgumentException("사용자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
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
