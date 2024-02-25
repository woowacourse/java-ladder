package ladderGame.model;

import java.util.regex.Pattern;

public class Result {

    private static final Pattern RESULT_PATTERN = Pattern.compile("^(꽝|\\d{1,5})$");
    private static final String EXCEPTION_MESSAGE_UNDEFINED_MESSAGE = "실행 결과는 꽝 또는 0 이상 99999 이하의 숫자만 입력 가능합니다.";

    private String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if(!RESULT_PATTERN.matcher(result).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_UNDEFINED_MESSAGE);
        }
    }

    public String getResult() {
        return result;
    }
}
