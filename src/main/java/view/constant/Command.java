package view.constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Command {
    ALL("all"),
    END("end");

    String command;

    Command(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static boolean isCommand(final String doubtWord) {
        return Arrays.stream(Command
                        .values())
                .filter(command -> command.getCommand().equals(doubtWord))
                .collect(Collectors.toList())
                .isEmpty();
    }
}
