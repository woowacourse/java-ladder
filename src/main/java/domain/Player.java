package domain;

public class Player {

    static final String ERROR_MAX_NAME_LENGTH = "이름은 5글자를 초과할 수 없습니다.";
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
