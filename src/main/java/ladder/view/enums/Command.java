package ladder.view.enums;

public enum Command {
    PRINT_ALL("all"),
    STOP("exit");

    private final String input;

    Command(String input) {
        this.input = input;
    }
    
    public static boolean contains(String s) {
        boolean isContaining = false;

        for (Command command : Command.values()) {
            isContaining |= command.input.equals(s);
        }
        return isContaining;
    }

    public boolean isSameWith(String name) {
        return this.input.equals(name);
    }
}
