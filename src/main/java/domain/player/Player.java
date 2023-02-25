package domain.player;


import domain.Direction;

public class Player {
    private final PlayerName name;
    private final PlayerPosition position;

    public Player(String playerName, int playerPosition) {
        this.name = new PlayerName(playerName);
        this.position = new PlayerPosition(playerPosition);
    }

    public void move(Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            position.moveRight();
        }
        if (direction.equals(Direction.LEFT)) {
            position.moveLeft();
        }
    }

    public String getPlayerName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
