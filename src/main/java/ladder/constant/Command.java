package ladder.constant;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum Command {
    ALL("all"),
    EXIT("exit");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Optional<Command> from(String command) {
        return Arrays.stream(values()).filter(c -> Objects.equals(c.value, command)).findFirst();
    }
}
