package game;

public enum LadderCommand {

    ALL("all");

    private final String command;

    LadderCommand(String command) {
        this.command = command;
    }

    public boolean isSameCommand(String input) {
        return command.equalsIgnoreCase(input);
    }
}
