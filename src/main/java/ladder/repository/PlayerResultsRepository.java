package ladder.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.PlayerResult;

public class PlayerResultsRepository {
    private final List<PlayerResult> playerResults = new ArrayList<>();

    public void save(PlayerResult playerResult) {
        this.playerResults.add(playerResult);
    }

    public PlayerResult findByPlayerName(String playerName) {
        return playerResults.stream()
                .filter(playerResult -> playerResult.isPlayerNameMatch(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 참여자가 없습니다."));
    }

    public List<PlayerResult> findAll() {
        return Collections.unmodifiableList(playerResults);
    }
}
