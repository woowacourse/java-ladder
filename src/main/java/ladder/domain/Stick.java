package ladder.domain;

import java.util.List;
import ladder.domain.player.Player;

public enum Stick {

    EXISTENCE, NON_EXISTENCE;

    public List<Player> progressSwitching(Player left, Player right) {
        if (isExist()) {
            return List.of(right, left);
        }
        return List.of(left, right);
    }

    public boolean isExist() {
        return this == EXISTENCE;
    }
}
