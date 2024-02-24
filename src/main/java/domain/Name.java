package domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 2;

    private final String name;

    public Name(String value) {
        validateNameLength(value);
        this.name = value;
    }

    private void validateNameLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5글자 이하만 입력할 수 있습니다.");
        }

        if (value.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 2글자 이상만 입력할 수 있습니다.");
        }
    }

    public String getValue() {
        return name;
    }
}
