package laddergame.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = String.format("이름 길이는 최대 %s자만 허용합니다.", MAX_NAME_LENGTH);
    public static final String NAME_BLANK_ERROR = "빈 이름은 허용하지 않습니다.";

    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        checkNameIsBlank(name);
        checkNameLength(name);
    }

    private void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void checkNameIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
