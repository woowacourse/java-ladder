package domain.player;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private int position;

    public Player(final PlayerName playerName, final int position) {
        this.playerName = playerName;
        this.position = position;
    }

    public void moveTo(final int direction) {
        position += direction;
    }

    public String getName() {
        return playerName.getName();
    }

    public int getPosition() {
        return position;
    }
}
