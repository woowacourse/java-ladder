package domain;

public class Player {

    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "사람 이름은 1글자에서 5글자 사이이어야 합니다.";

    private final String name;

    public Player(String name) {
        String trimmedName = name.trim();
        validate(trimmedName);
        this.name = trimmedName;
    }

    private static void validate(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private static boolean isInvalidNameLength(String name) {
        int length = name.length();
        return length < NAME_LENGTH_LOWER_BOUND || length > NAME_LENGTH_UPPER_BOUND;
    }

    public String getName() {
        return name;
    }
}
