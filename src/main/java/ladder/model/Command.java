package ladder.model;

public enum Command {

    ALL("all"),
    QUIT("quit");

    private final String message;

    Command(String command) {
        this.message = command;
    }

    public String getCommand() {
        return message;
    }

}
