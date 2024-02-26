package domain.result;

import java.util.regex.Pattern;

public record Result(String rawResult) {

    private static final Pattern RESULT_REGEX = Pattern.compile("^[a-zA-Z0-9가-힣]*$");
    private static final int RESULT_MAX_LENGTH = 5;

    public Result {
        validateResultLength(rawResult);
        validateResultPattern(rawResult);
    }

    private void validateResultLength(String result) {
        if (result == null || isResultLengthOutOfRange(result)) {
            throw new IllegalArgumentException("결과는 1글자에서 5글자 사이여야 합니다.");
        }
    }

    private boolean isResultLengthOutOfRange(String result) {
        return result.isEmpty() || result.length() > RESULT_MAX_LENGTH;
    }

    private void validateResultPattern(String result) {
        boolean isPatternMatches = RESULT_REGEX.matcher(result).matches();
        if (!isPatternMatches) {
            throw new IllegalArgumentException("결과는 알파벳 대소문자, 숫자나 한글로 이루어져야 합니다.");
        }
    }
}
