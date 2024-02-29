package domain;

import java.util.Arrays;
import java.util.StringJoiner;

public enum Command {
    ALL("all"),
    EXIT("exit");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static boolean contains(String string) {
        return Arrays.stream(Command.values())
                .anyMatch(e -> e.command.equals(string));
    }

    public static String getCommandToString() {
        StringJoiner result = new StringJoiner(", ");
        for (Command e : Command.values()) {
            result.add(e.getCommand());
        }
        return result.toString();
    }

    public String getCommand() {
        return this.command;
    }
}
