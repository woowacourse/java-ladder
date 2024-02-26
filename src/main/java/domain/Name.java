package domain;


public class Name {

    public static final String INVALID_NAME_LENGTH = "이름은 1자 이상 5자 이하 이어야 합니다.";
    private static final int MAXIMUM_NAME = 5;
    private final String value;

    public Name(final String value) {
        validateNameLength(value);
        this.value = value;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
