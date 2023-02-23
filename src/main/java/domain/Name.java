package domain;

public class Name {
    public static final int MAX_LENGTH = 5;
    private static final String BLANK_NAME_MESSAGE = "빈 문자열 입니다.";
    private static final String INVALID_NAME_LENGTH_MESSAGE = "글자 길이는 "
            + MAX_LENGTH + "자를 넘길 수 없습니다.";

    private final String name;

    public Name(String name) {
        this.name = name;
        validateNameLength(name);
        validateNameBlank(name);
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

}
