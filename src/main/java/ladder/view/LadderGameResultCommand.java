package ladder.view;

import ladder.domain.player.Player;

public record LadderGameResultCommand(Player player) {

    public static final String ALL_PLAYERS = "all";

    public boolean isAll() {
        return ALL_PLAYERS.equals(player.name());
    }
}
