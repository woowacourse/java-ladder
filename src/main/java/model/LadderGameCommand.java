package model;

public enum LadderGameCommand {

    DEFAULT_COMMAND("all");

    private final String command;

    LadderGameCommand(String command) {
        this.command = command;
    }

    public boolean isPlayable(String command) {
        return !this.command.equals(command);
    }
}
