package view;

public enum LadderCommand {
    ALL_COMMAND("ALL");

    private String value;

    LadderCommand(final String value) {
        this.value = value;
    }

    public static boolean isAllCommand(String command) {
        return command.equals(ALL_COMMAND);
    }
}
