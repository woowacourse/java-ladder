package ladder.domain.player;

import ladder.constant.Command;

import java.util.Objects;

public class PlayerName {

    public static final int NAME_MAXIMUM_LENGTH = 5;
    private static final String COMMAND = Command.REQUEST_TO_GET_ALL_RESULT;
    private static final String ERROR_SAME_AS_COMMAND = String.format(
            "%s은 플레이어의 이름으로 불가능 합니다.", COMMAND);
    private static final String ERROR_LENGTH_OF_NAME = String.format(
            "플레이어의 이름은 %d자 이하여야 합니다.", NAME_MAXIMUM_LENGTH);
    private final String name;

    public PlayerName(final String name) {
        validateNameLength(name);
        validateCommandName(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
        }
    }

    private void validateCommandName(final String name) {
        if (name.equals(COMMAND)) {
            throw new IllegalArgumentException(ERROR_SAME_AS_COMMAND);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PlayerName name1 = (PlayerName) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

}
