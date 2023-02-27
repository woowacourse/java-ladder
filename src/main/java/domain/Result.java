package domain;

public class Result {

    String result;

    public Result(String result) {
        validateLength(result);
        this.result = result;
    }

    private void validateLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 입력값은 6자를 초과할 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
