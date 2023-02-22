package domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final GameResults gameResults) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public GameResults getGameResults() {
        return gameResults;
    }

    public void getGameResultOf(String playerName) {
        if (!players.contains(playerName)) {
            throw new IllegalArgumentException("찾는 플레이어가 없습니다.");
        }

    }
}
