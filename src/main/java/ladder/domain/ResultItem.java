package ladder.domain;

public class ResultItem {

    public static final int MAX_LENGTH = 5;

    private final String content;

    public ResultItem(String rawContent) {
        String content = parse(rawContent);
        validate(content);
        this.content = content;
    }

    private String parse(String content) {
        return content.trim();
    }

    private void validate(String content) {
        validateMinLength(content);
        validateMaxLength(content);
    }

    private void validateMinLength(String content) {
        if (content.isEmpty()) {
            throw new IllegalArgumentException("결과 항목은 1글자 이상이어야 합니다.");
        }
    }

    private void validateMaxLength(String content) {
        if (content.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("결과 항목은 5글자 이하여야 합니다.");
        }
    }
}
