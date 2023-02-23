package domain;

public final class PlayerName {
    public static final String ALL = "all";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 1이상 5글자 이하입니다.";
    private static final String NAME_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 빈칸이면 안됩니다.";
    private static final String NAME_IS_ALL_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 all이 될 수 없습니다";
    private final String name;

    public PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    public static void validateName(String name) {
        validateNameIsBlank(name);
        validateNameLength(name);
        validateNameIsAll(name);
    }

    private static void validateNameIsAll(String name) {
        if (name.equals(ALL)) {
            throw new IllegalArgumentException(NAME_IS_ALL_ERROR_MESSAGE);
        }
    }

    private static void validateNameIsBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateNameLength(String name) {
        if (isLengthError(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isLengthError(String name) {
        return name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH;
    }

    public String getName() {
        return name;
    }
}
