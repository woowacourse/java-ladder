package domain.player;


import domain.Direction;

public class Player {
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";
    private final PlayerName name;
    private final PlayerPosition position;

    public Player(String playerName, int playerPosition) {
        checkNotEmpty(playerName);
        this.name = new PlayerName(playerName);
        this.position = new PlayerPosition(playerPosition);
    }

    private void checkNotEmpty(String playerName) {
        checkNull(playerName);
        checkBlank(playerName);
    }

    private static void checkBlank(String playerName) {
        if (playerName.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }

    private static void checkNull(String playerName) {
        if (playerName == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    public void playerMove(Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            position.rightMovement();
        }
        if (direction.equals(Direction.LEFT)) {
            position.leftMovement();
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
