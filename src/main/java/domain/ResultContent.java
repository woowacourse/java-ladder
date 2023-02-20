package domain;

public class ResultContent {

    private static final int RESULT_CONTENT_MIN_SIZE_INCLUSIVE = 1;
    private static final int RESULT_CONTENT_MAX_SIZE_INCLUSIVE = 5;
    private static final String RESULT_CONTENT_SIZE_ERROR_MESSAGE = "실행 결과의 이름은 1 ~ 5 글자여야 합니다.";

    private final String content;

    public ResultContent(String content) {
        validate(content);
        this.content = content;
    }

    private void validate(String content) {
        validateRange(content);
    }

    private void validateRange(String content) {
        if (isOutOfRange(content)) {
            throw new IllegalArgumentException(RESULT_CONTENT_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(String playerName) {
        return !(RESULT_CONTENT_MIN_SIZE_INCLUSIVE <= playerName.length()
                && playerName.length() <= RESULT_CONTENT_MAX_SIZE_INCLUSIVE);
    }

    public String getContent() {
        return this.content;
    }
}
