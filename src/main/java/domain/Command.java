package domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public enum Command {
    ALL("all"),
    EXIT("exit");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static boolean contains(String input) {
        return Arrays.stream(Command.values())
                .anyMatch(e -> e.value.equals(input));
    }

    public static boolean isAll(String input) {
        return Objects.equals(input, ALL.getValue());
    }

    public static boolean isExit(String input) {
        return Objects.equals(input, EXIT.getValue());
    }

    public static String getCommandToString() {
        StringJoiner result = new StringJoiner(", ");
        for (Command e : Command.values()) {
            result.add(e.getValue());
        }
        return result.toString();
    }

    public String getValue() {
        return this.value;
    }
}
