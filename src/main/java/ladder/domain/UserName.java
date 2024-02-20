package ladder.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record UserName(String name) {
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_\\-&]");

    public UserName {
        validateNotEmpty(name);
        validateNameLength(name);
        validateNamePattern(name);
    }

    private void validateNotEmpty(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름에 공백을 입력할 수 없습니다");
        }
    }

    private void validateNamePattern(final String name) {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof UserName userName)) return false;
        return Objects.equals(name, userName.name);
    }
}
