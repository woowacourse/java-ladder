package domain;

public class Player {
    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 최대 5글자까지입니다.";
    public static final int NAME_MAX_LENGTH = 5;
    public static final String NAME_NULL_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 null이면 안됩니다.";
    public static final String NAME_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 빈칸이면 안됩니다.";
    private String name;

    public Player(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        validateNameIsNull(name);
        validateNameIsBlank(name);
        validateNameLength(name);

        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateNameIsNull(String name) {
        if (name.equals(null)) {
            throw new IllegalArgumentException(NAME_NULL_ERROR_MESSAGE);
        }
    }

    private void validateNameIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }
}
