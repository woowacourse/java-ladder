package model;

public enum LadderGameCommand {

    ALL_RESULT_PRINT_AND_EXIT_COMMAND("all");

    private final String command;

    LadderGameCommand(String command) {
        this.command = command;
    }

    public boolean isPlayable(String command) {
        return !this.command.equals(command);
    }
}
