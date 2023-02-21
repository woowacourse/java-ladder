package ladder.domain;

public class Result {

    private static final int MAXIMUM_RESULT_LENGTH = 5;

    private final String value;

    public Result(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("결과는 공백일 수 없습니다. 현재 입력한 값은 " + value + " 입니다.");
        }
        if (isLong(value)) {
            throw new IllegalArgumentException(
                    "결과는 최대 " + MAXIMUM_RESULT_LENGTH + "글자까지 가능합니다. 현재 입력한 값은 " + value + " 입니다.");
        }
    }

    private boolean isLong(final String value) {
        return value.length() > MAXIMUM_RESULT_LENGTH;
    }

    public String getValue() {
        return value;
    }
}
