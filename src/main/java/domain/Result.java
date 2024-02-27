package domain;

public class Result {

    public static final int MIN_RESULT_LENGTH = 1;
    public static final int MAX_RESULT_LENGTH = 5;

    private final String value;

    public Result(String value) {
        validateNull(value);
        validateLength(value);
        this.value = value;
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("결과에 null을 입력할 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() < MIN_RESULT_LENGTH || value.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("1~5자의 결과만 허용합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
