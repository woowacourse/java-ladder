package ladderGame.model;

public class Result {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if(result.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 최대 5글자까지 가능합니다.");
        }
    }
}
