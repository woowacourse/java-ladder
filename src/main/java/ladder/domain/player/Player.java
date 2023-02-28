package ladder.domain.player;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    private Player(final PlayerName playerName, final Position position) {
        this.playerName = playerName;
        this.position = position;
    }

    public static Player of(final String name, final int initialPosition) {
        PlayerName playerName = new PlayerName(name);
        Position position = new Position(initialPosition);
        return new Player(playerName, position);
    }

    public void moveLeft() {
        position.moveLeft();
    }

    public void moveRight() {
        position.moveRight();
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public Position getPosition() {
        return position;
    }
}
