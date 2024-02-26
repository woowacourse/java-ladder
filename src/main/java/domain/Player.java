package domain;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1자 이상 %d자 이하 이어야 합니다.", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
