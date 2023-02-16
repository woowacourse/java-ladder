package ladder.domain;

public class Player {
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 1자 이상, " +
            NAME_LENGTH_UPPER_BOUND + "자 이하여야 한다.";

    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private boolean isInvalidNameLength(final String name) {
        return name.isBlank() || NAME_LENGTH_UPPER_BOUND < name.length();
    }

    public String getName() {
        return name;
    }
}
