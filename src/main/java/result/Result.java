package result;

import java.util.regex.Pattern;

public class Result {

    private static final Pattern RESULT_REGEX = Pattern.compile("^[a-zA-Z가-힣0-9]*$");
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    Result(String name) {
        validateNameLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name == null || isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException("결과는 1글자에서 5글자 사이여야 합니다.");
        }
    }

    private boolean isNameLengthOutOfRange(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    private void validateNamePattern(String name) {
        boolean isPatternMatched = RESULT_REGEX.matcher(name).matches();
        if (!isPatternMatched) {
            throw new IllegalArgumentException("결과는 알파벳 대소문자, 숫자나 한글로만 이루어져야 합니다.");
        }
    }
}
