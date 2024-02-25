package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final List<String> userNames, final int maxLadderHeight) {
        return new Players(Collections.emptyList());
    }
}
