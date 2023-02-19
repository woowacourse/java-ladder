package domain;

public class Name {
    private static final String ERROR_NAME_LENGTH = "[ERROR] 이름의 길이는 1~5자 내로 입력 가능합니다";
    private static final int NAME_MAX_LENGTH_INCLUSIVE = 5;
    private static final int NAME_MIN_LENGTH_INCLUSIVE = 1;

    private final String value;

    public Name(final String name) {
        validateNameSize(name);
        this.value = name;
    }

    private static void validateNameSize(String name) {
        if (name.length() < NAME_MIN_LENGTH_INCLUSIVE || name.length() > NAME_MAX_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
