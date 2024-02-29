package domain;

public class Player {

    private final PlayerName playerName;
    private final ColumnPosition columnPosition;

    public Player(PlayerName playerName, ColumnPosition columnPosition) {
        this.playerName = playerName;
        this.columnPosition = columnPosition;
    }

    public String getName() {
        return playerName.getName();
    }

    public int getColumnPosition() {
        return columnPosition.getColumnPosition();
    }
}
