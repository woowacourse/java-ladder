package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<PlayerName> players;

    public Players(List<PlayerName> playerNames) {
        this.players = playerNames;
    }

    public List<String> getPlayerNames() {
        List<String> playerNames = new ArrayList<>();
        for (PlayerName player : players) {
            playerNames.add(player.getName());
        }
        return playerNames;
    }
}
