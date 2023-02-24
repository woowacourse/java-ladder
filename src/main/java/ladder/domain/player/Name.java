package ladder.domain.player;

import java.util.List;

public class Name {

    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 참여자의 이름은 1자 이상 5자 이하여야 합니다.";
    private static final String BLANK_EXCEPTION_MESSAGE = "[ERROR] 참여자의 이름은 빈 값일 수 없습니다.";

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(final String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    private boolean isBlank(final String name) {
        return name.isBlank();
    }

    private void validateLength(final String name) {
        if (isWrongLength(name)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private boolean isWrongLength(final String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public String getRawName() {
        return name;
    }
}
