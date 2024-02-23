package ladder.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record UserName(String value) {
    private static final int MAX_LENGTH = 5;
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_\\-&]");

    public UserName {
        if (Objects.equals(value, "all")) {
            throw new IllegalArgumentException("'all'은 사용할 수 없는 이름입니다.");
        }
        validateNotEmpty(value);
        validateNameLength(value);
        validateNamePattern(value);
    }

    private void validateNotEmpty(final String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름에 공백을 입력할 수 없습니다");
        }
    }

    private void validateNamePattern(final String name) throws IllegalArgumentException {
        Matcher matcher = NAME_PATTERN.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("이름에는 한글, 영문, 숫자, `-`, `_`, `&`만 포함될 수 있습니다.");
        }
    }

    private void validateNameLength(final String name) throws IllegalArgumentException {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("이름의 길이는 %d 이하여야 합니다.", MAX_LENGTH)
            );
        }
    }
}
