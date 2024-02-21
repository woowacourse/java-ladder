package model;

public record Player(String name) {
    public static final int MAX_LENGTH_OF_NAME = 5;
    private static final String INVALID_LENGTH_OF_NAME = "참여자 이름은 최대 5글지입니다.";

    public Player {
        validateLengthOfName(name);
    }

    private void validateLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(INVALID_LENGTH_OF_NAME);
        }
    }
}
