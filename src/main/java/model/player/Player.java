package model.player;

public record Player(String name) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH = "참여자 이름은 최대 5글자입니다.";

    public Player {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
