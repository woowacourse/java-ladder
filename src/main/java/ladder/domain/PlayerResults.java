package ladder.domain;

import java.util.List;

public class PlayerResults {
    private final List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public PlayerResult findByPlayer(Player player) {
        return playerResults.stream()
                .filter(playerResult -> playerResult.isPlayerMatch(player))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 참여자가 없습니다."));
    }
}
