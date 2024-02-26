package ladder.domain.participant;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]*$";

    private final String value;

    public Name(final String name) {
        validateLength(name);
        validateIsAlphabetic(name);
        this.value = name;
    }

    private void validateLength(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1에서 5자 사이로 입력해 주세요.");
        }
    }

    private void validateIsAlphabetic(final String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름은 영어로 입력해 주세요.");
        }
    }

    public String getValue() {
        return value;
    }
}
