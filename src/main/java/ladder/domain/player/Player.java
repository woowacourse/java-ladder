package ladder.domain.player;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    private Player(PlayerName playerName, Position position) {
        this.playerName = playerName;
        this.position = position;
    }

    public static Player of(String name, int initialPosition) {
        PlayerName playerName = new PlayerName(name);
        Position position = new Position(initialPosition);
        return new Player(playerName, position);
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public Position getPosition() {
        return position;
    };
}
