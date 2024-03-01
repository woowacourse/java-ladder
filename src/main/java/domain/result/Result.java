package domain.result;

import java.util.regex.Pattern;

public class Result {
    private static final Pattern ALPHABET_NUMERIC = Pattern.compile("^[a-zA-Z0-9]*$");
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Result(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateEmptiness(name);
        validateLength(name);
        validateCharacter(name);
    }

    private void validateEmptiness(final String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("결과는 비어있을 수 없습니다.");
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 결과의 최대 길이는 5입니다.", name));
        }
    }

    private void validateCharacter(final String name) {
        if (name.equals("꽝")) {
            return;
        }
        if (!ALPHABET_NUMERIC.matcher(name).find()) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 영문,숫자 조합 혹은 '꽝'만 입력해주세요", name));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
