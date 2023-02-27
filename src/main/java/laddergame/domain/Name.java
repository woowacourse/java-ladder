package laddergame.domain;

public class Name {
    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "플레이어 이름은 1~5글자만 가능합니다.";

    private final String name;

    public Name(String name) {
        checkLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkLength(String name) {
        if (name.length() > PLAYER_NAME_MAX_SIZE || name.isBlank()) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
