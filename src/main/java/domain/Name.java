package domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("빈 값을 이름으로 사용할 수 없습니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public boolean isSameName(String name) {
        return this.value.equals(name);
    }

    public String getValue() {
        return value;
    }
}
