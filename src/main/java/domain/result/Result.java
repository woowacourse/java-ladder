package domain.result;

import java.util.regex.Pattern;

public record Result(String result) {

    private static final Pattern RESULT_REGEX = Pattern.compile("^[a-zA-Z0-9가-힣]*$");

    public Result {
        if (result == null || !RESULT_REGEX.matcher(result).matches() || result.length() > 5 || result.isEmpty()) {
            throw new IllegalArgumentException("결과는 1글자에서 5글자 사이여야 합니다.");
        }
    }
}
