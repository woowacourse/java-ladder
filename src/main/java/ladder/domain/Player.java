package ladder.domain;

import static ladder.view.InputView.ALL_RESULT_COMMAND;
import static ladder.view.InputView.QUIT_RESULT_COMMAND;

public record Player(String name, int location) {
    private static final int MAX_NAME_LENGTH = 5;

    public Player {
        validate(name);
    }

    public boolean hasSameLocation(int location) {
        return this.location == location;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateInvalidName(name);
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 1~%d글자 사이로 입력해주세요: %s".formatted(MAX_NAME_LENGTH, name)
            );
        }
    }

    private void validateInvalidName(String name) {
        if (name.equals(ALL_RESULT_COMMAND) || name.equals(QUIT_RESULT_COMMAND)) {
            throw new IllegalArgumentException("명령어를 이름으로 가질 수 없습니다: %s".formatted(name));
        }
    }
}
