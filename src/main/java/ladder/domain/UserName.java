package ladder.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserName {
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_\\-&]");

    private final String name;

    public UserName(final String name) {
        validateNotEmpty(name);
        validateNameLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    private void validateNotEmpty(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름에 공백을 입력할 수 없습니다");
        }
    }

    private static void validateNamePattern(final String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("이름에는 한글, 영문, 숫자, `-`, `_`, `&`만 포함될 수 있습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5 이하여야 합니다.");
        }
    }
}
