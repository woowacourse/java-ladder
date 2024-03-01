package domain;

public class MemberName {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME = "all";
    private static final String FORMAT_NAME = "^[A-Za-z0-9]+$";

    private final String name;

    public MemberName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNull(name);
        validateLength(name);
        validatePattern(name);
    }

    private void validateNull(String name) {
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
        if (name.equals(INVALID_NAME)) {
            throw new IllegalArgumentException("'all'이라는 이름을 사용할 수 없습니다.");
        }
        if (!name.matches(FORMAT_NAME)) {
            throw new IllegalArgumentException("이름은 알파벳과 숫자만 허용합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
