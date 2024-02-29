package domain.player;

import domain.Name;

public class PlayerName extends Name {

    public PlayerName(String playerName) {
        super(playerName);
    }

    public boolean isAll() {
        return super.getValue()
                    .equals("all");
    }
}
