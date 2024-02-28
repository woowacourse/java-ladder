package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private final List<PlayerName> players;

    public Players(List<PlayerName> playerNames) {
        this.players = playerNames;
    }

    public void changePosition(int present, int after) {
        Collections.swap(players, present, after);
    }

    public List<String> getPlayerNames() {
        List<String> playerNames = new ArrayList<>();
        for (PlayerName player : players) {
            playerNames.add(player.getName());
        }
        return Collections.unmodifiableList(playerNames);
    }
}
