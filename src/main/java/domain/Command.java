package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        return ALL.value.equals(input);
    }

    public static boolean isExit(String input) {
        return EXIT.value.equals(input);
    }

    public static String getCommandToString() {
        return Arrays.stream(values())
                .map(Command::getValue)
                .collect(Collectors.joining(", "));
    }

    public String getValue() {
        return this.value;
    }
}
