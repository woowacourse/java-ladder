package domain;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String UPPER_LOWER_DIGIT = "^[A-Za-z0-9]+$";

    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        validateNull(name);
        return new Name(name);
    }

    private void validate(String name) {
        validateLength(name);
        validatePattern(name);
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에 null을 입력할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자의 이름만 허용합니다.");
        }
    }

    private void validatePattern(String name) {
        if (!name.matches(UPPER_LOWER_DIGIT)) {
            throw new IllegalArgumentException("이름은 알파벳과 숫자만 허용합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
