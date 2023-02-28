package utils;

import java.util.Arrays;
import java.util.List;

public enum Command {
    ALL_PRINT_COMMAND("all"),
    FINISH_GAME_COMMAND("finish");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public static boolean isIn(List<String> names) {
        return Arrays.stream(values())
                .anyMatch(x -> names.contains(x.getCommand()));
    }

    private String getCommand() {
        return command;
    }

    public boolean isEqualTo(String command) {
        return this.command.equals(command);
    }
}
