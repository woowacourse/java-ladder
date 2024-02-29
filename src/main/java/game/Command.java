package game;

public enum Command {

    ALL("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public boolean isSameCommand(String input) {
        return command.equalsIgnoreCase(input);
    }
}
