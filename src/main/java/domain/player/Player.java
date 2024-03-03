package domain.player;

import domain.ColumnPosition;

public class Player {

    private final PlayerName playerName;
    private final ColumnPosition columnPosition;

    public Player(PlayerName playerName, ColumnPosition columnPosition) {
        this.playerName = playerName;
        this.columnPosition = columnPosition;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public ColumnPosition getColumnPosition() {
        return columnPosition;
    }
}
