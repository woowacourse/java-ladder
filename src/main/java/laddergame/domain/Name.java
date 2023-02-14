package laddergame.domain;

public class Name {

    private static final String NAME_LENGTH_RANGE_MESSAGE = "1이상 5글자 이하의 이름을 입력해 주세요.";

    private final String name;

    public Name(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_MESSAGE);
        }
    }
}
