package domain.player;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private Position position;

    public Player(final String name) {
        validateNameLength(name);

        this.name = name;
        this.position = new Position();
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1자 이상 %d자 이하 이어야 합니다.", MAX_NAME_LENGTH));
        }
    }

    public void moveLeft() {
        position = position.decrease();
    }

    public void moveRight() {
        position = position.increase();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
