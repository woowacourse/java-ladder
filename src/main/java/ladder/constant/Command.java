package ladder.constant;

import java.util.Arrays;
import java.util.Objects;

public enum Command {
    ALL("all"),
    EXIT("exit");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static boolean exist(String command) {
        return Arrays.stream(Command.values()).anyMatch(c -> Objects.equals(c.value, command));
    }
}
