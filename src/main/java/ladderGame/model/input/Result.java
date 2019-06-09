package ladderGame.model.input;

public class Result {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private String name;

    public Result(String splittedInput) {
        checkLength(splittedInput);
        this.name = splittedInput;
    }

    private void checkLength(String splittedInput) {
        if (splittedInput.length() < MIN_LENGTH || splittedInput.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("결과의 길이는 1 이상 5이하입니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
