package ladder.domain;

public enum Command {
    QUIT("q"),
    ALL("all");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static boolean isQuit(String input) {
        return QUIT.command.equals(input);
    }

    public static boolean isAll(String input) {
        return ALL.command.equals(input);
    }
}
