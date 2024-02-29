package domain.player;

import domain.Name;

public class PlayerName extends Name {
    private static final String NAME_ALL = "all";

    public PlayerName(String playerName) {
        super(playerName);
    }

    public boolean isAll() {
        return super.getValue()
                .equals(NAME_ALL);
    }
}
