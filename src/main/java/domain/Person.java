package domain;

public class Person {
    public static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK_NAME_ERROR = "[ERROR] 빈 문자열 입니다.";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름 길이는 5자를 넘길 수 없습니다.";
    private final String name;

    public Person(String name) {
        this.name = name;
        validateNameLength(name);
        validateNameBlank(name);
    }

    public String getName() {
        return name;
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

}
