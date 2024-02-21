package ladder.domain.player;

import java.util.regex.Pattern;

public class Player {
    private static final int MAXIMUM_NAME_RANGE = 5;
    private static final Pattern NAME_VALID_FORMAT = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]+");
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateRange(name);
        validateFormat(name);
    }

    private void validateFormat(String name) {
        if (isInvalidFormat(name)) {
            throw new IllegalArgumentException("참가자들의 이름은 영어, 숫자가 아니라면 예외가 발생한다.");
        }
    }

    private void validateRange(String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new IllegalArgumentException(
                    String.format("참가자들의 이름은 %d글자를 초과할 수 없습니다.", MAXIMUM_NAME_RANGE));
        }
    }

    private boolean isInvalidFormat(String name) {
        return !NAME_VALID_FORMAT.matcher(name)
                .matches();
    }

    public String getName() {
        return name;
    }
}
