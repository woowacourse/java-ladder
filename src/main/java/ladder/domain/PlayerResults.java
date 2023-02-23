package ladder.domain;

import java.util.Collections;
import java.util.List;

public class PlayerResults {
    private final List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public PlayerResult findByPlayerName(String playerName) {
        return playerResults.stream()
                .filter(playerResult -> playerResult.isPlayerNameMatch(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 참여자가 없습니다."));
    }

    public List<PlayerResult> getPlayerResults() {
        return Collections.unmodifiableList(playerResults);
    }
}
