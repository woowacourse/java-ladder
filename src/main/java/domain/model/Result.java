package domain.model;

public class Result {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    public static final String LENGTH_ERROR_MESSAGE = "결과의 길이는 " + MIN_LENGTH + "~" + MAX_LENGTH + "글자입니다.";
    private final String value;

    public Result(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (validateLength(value)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean validateLength(final String value) {
        return value.length() < MIN_LENGTH || value.length() > MAX_LENGTH;
    }

    public String getValue() {
        return value;
    }
}
