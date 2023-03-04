package constant;

import java.util.Arrays;

public enum Command {

    ALL("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static boolean isAll(String input) {
        if (isCommand(input)) {
            return ALL.hasCommand(input);
        }
        return false;
    }

    public static boolean isCommand(String input) {
        return Arrays.stream(values())
                .anyMatch(command -> command.hasCommand(input));
    }

    private boolean hasCommand(String command) {
        return this.command.equals(command);
    }
}
