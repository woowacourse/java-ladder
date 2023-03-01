package domain;

public class PlayerName {
    public static final int MAX_LENGTH = 5;
    private static final String BLANK_NAME_MESSAGE = "빈 문자열 입니다.";
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름 길이는 %d자를 넘길 수 없습니다.";
    private static final String IMPOSSIBLE_NAME_NOTICE = "%s은 불가능한 이름입니다.";
    private static final String RESERVED_NAME = "all";

    private final String name;

    public PlayerName(String name) {
        validateNameLength(name);
        validateNameBlank(name);
        validateName(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NAME_LENGTH_MESSAGE, MAX_LENGTH));
        }
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_MESSAGE);
        }
    }

    private void validateName(String name) {
        if (name.equals(RESERVED_NAME)) {
            throw new IllegalArgumentException(
                    String.format(IMPOSSIBLE_NAME_NOTICE, RESERVED_NAME));
        }
    }

    public String getName() {
        return name;
    }

}
