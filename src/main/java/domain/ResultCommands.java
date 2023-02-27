package domain;

public enum ResultCommands {
    ALL,
    QUIT;

    public static boolean isQuit(String command) {
        return QUIT.name().equals(command);
    }

    public static boolean isAll(String command) {
        return ALL.name().equals(command);
    }
}
