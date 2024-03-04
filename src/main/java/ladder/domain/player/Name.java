package ladder.domain.player;

import java.util.regex.Pattern;

public class Name {
    private static final int MAXIMUM_NAME_RANGE = 5;
    private static final Pattern NAME_VALID_FORMAT = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]+");

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateRange(name);
        validateFormat(name);
    }

    private void validateFormat(final String name) {
        if (isInvalidFormat(name)) {
            throw new IllegalArgumentException("참가자들의 이름은 영어, 숫자여야 합니다.");
        }
    }

    private void validateRange(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new IllegalArgumentException(
                    String.format("참가자들의 이름은 %d글자를 초과할 수 없습니다.", MAXIMUM_NAME_RANGE));
        }
    }

    private boolean isInvalidFormat(final String name) {
        return !NAME_VALID_FORMAT.matcher(name)
                .matches();
    }

    public String getValue() {
        return name;
    }
}
