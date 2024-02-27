package domain;

public enum Command {
    ALL("all"),
    EXIT("exit");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
