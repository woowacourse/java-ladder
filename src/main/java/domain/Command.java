package domain;

public enum Command {
    ALL("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    //TODO
    public static boolean isAllCommand(String command) {
        return command.equals(ALL.command);
    }

    public String getCommand() {
        return command;
    }
}
