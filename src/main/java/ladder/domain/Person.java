package ladder.domain;

public class Person {
    private static final int MAX_LENGTH = 5;
    private static final String MAX_PERSON_NAME_LENGTH = "사람 이름의 길이는 5자를 넘을 수 없습니다.";
    private static final String PERSON_NAME_NOT_BLANK = "사람 이름의 비어있거나 공백일 수 없습니다.";

    private final String name;

    public Person(String name) {
        this.name = name.strip();
        validate(this.name);
    }

    public static int getMaxLength() {
        return MAX_LENGTH;
    }

    private void validate(String name) {
        validateLength(name);
        validateBlank(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_PERSON_NAME_LENGTH);
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(PERSON_NAME_NOT_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
