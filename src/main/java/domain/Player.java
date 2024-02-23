package domain;

public class Player {

    private static final int MAXIMUM_NAME = 5;
    private final String name;

    public Player(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하 이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
