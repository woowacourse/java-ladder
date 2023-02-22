package ladder.model;

import java.util.Arrays;

public enum Command {

    LOOK_ALL_PLAYERS_RESULT("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean contains(String word) {
        Command[] commands = Command.values();
        return Arrays.stream(commands)
                .map(Command::getCommand)
                .anyMatch(command -> command.equals(word));
    }
}
