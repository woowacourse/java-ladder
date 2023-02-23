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
        return Arrays.stream(Command.values())
                .filter(x -> names.contains(x.getCommand()))
                .count() != 0;
    }

    private String getCommand() {
        return command;
    }
}
