package model;

import java.util.Arrays;
import java.util.Objects;

public enum Command {
    NAME("other"),
    ALL("all"),
    EXIT("exit");

    private final String commandValue;

    Command(String commandValue) {
        this.commandValue = commandValue;
    }

    public static Command inputTextToCommand(String inputText) {
        return Arrays.stream(Command.values())
                .filter(command -> Objects.equals(command.getCommandValue(), inputText))
                .findFirst()
                .orElse(NAME);
    }

    public String getCommandValue() {
        return commandValue;
    }
}
