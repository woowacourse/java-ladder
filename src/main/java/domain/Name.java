package domain;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ALPHABETS_NUMBERS = "^[A-Za-z0-9]+$";
    private static final String COMMAND_ALL_RESULT = "all";

    private final String value;

    private Name(String value) {
        validate(value);
        this.value = value;
    }

    public static Name from(String name) {
        validateNull(name);
        return new Name(name);
    }

    private void validate(String name) {
        validateGameCommandInclusion(name);
        validateLength(name);
        validatePattern(name);
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에 null을 입력할 수 없습니다.");
        }
    }

    private void validateGameCommandInclusion(String name) {
        if (name.equals(COMMAND_ALL_RESULT)) {
            throw new IllegalArgumentException("게임에서 지정한 명령어는 이름으로 지정할 수 없습니다: " + name);
        }
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format("%d~%d자의 이름만 허용합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    private void validatePattern(String name) {
        if (name.matches(ALPHABETS_NUMBERS)) {
            return;
        }
        throw new IllegalArgumentException("이름은 알파벳과 숫자만 허용합니다.");
    }

    public String getValue() {
        return value;
    }
}
