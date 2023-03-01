package constant;

import java.util.Arrays;

public enum Command {

    ALL("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static boolean isAll(String input) {
        if (isNotCommand(input)) {
            return false;
        }
        return ALL.hasCommand(input);
    }

    private static boolean isNotCommand(String input) {
        return Arrays.stream(values())
                .noneMatch(command -> command.hasCommand(input));
    }

    private boolean hasCommand(String command) {
        return this.command.equals(command);
    }
}
