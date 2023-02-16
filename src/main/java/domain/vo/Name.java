package domain.vo;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_ERROR_MESSAGE = "이름 길이는 %d ~ %d 사이여야 합니다.";
    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String target) {
        if (target.length() < MIN_LENGTH || target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(LENGTH_ERROR_MESSAGE, MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String get() {
        return value;
    }
}
