package domain;

public class Result {

    private static final int MAXIMUM_LENGTH_OF_LETTERS = 5;

    private final String result;

    public Result(String result) {
        validateLength(result);
        this.result = result;
    }

    private void validateLength(String input) {
        if (input.length() > MAXIMUM_LENGTH_OF_LETTERS) {
            throw new IllegalArgumentException("[ERROR] 입력값은 6자를 초과할 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
