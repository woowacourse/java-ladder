package domain;

public class Name {
    private static final int NAME_MAX_LENGTH_INCLUSIVE = 5;
    private static final int NAME_MIN_LENGTH_INCLUSIVE = 1;
    private static final String BANNED_NAME = "all";
    private static final String ERROR_NAME_LENGTH =
            "[ERROR] 이름의 길이는 " + NAME_MIN_LENGTH_INCLUSIVE + "~" + NAME_MAX_LENGTH_INCLUSIVE + "자 내로 입력 가능합니다";
    private static final String ERROR_NAME_IN_BAN_LIST =
            "[ERROR] " + BANNED_NAME + "은 이름으로 사용하실 수 없습니다";

    private final String value;

    public Name(final String name) {
        validateName(name);
        this.value = name;
    }

    private void validateName(String name) {
        validateBannedName(name);
        validateNameSize(name);
    }

    private void validateBannedName(String name) {
        if (name.equals(BANNED_NAME)) {
            throw new IllegalArgumentException(ERROR_NAME_IN_BAN_LIST);
        }
    }

    private void validateNameSize(String name) {
        if (name.length() < NAME_MIN_LENGTH_INCLUSIVE || name.length() > NAME_MAX_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
