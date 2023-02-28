package domain;

public class Name {

    private static final int MINIMUM_LENGTH_OF_NAME = 1;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String value;

    public Name(final String value) {
        validateLengthOfName(value);
        this.value = value;
    }

    private void validateLengthOfName(final String value) {
        if (isNotPermittedLengthOfName(value)) {
            throw new IllegalArgumentException("이름의 길이는 최소 1자 이상, 5자 이하입니다.");
        }
    }

    private boolean isNotPermittedLengthOfName(final String value) {
        return (value.length() < MINIMUM_LENGTH_OF_NAME) || (value.length() > MAXIMUM_LENGTH_OF_NAME);
    }

    public String getValue() {
        return this.value;
    }
}
