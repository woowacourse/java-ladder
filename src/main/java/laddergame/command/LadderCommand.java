package laddergame.command;

public enum LadderCommand {
    ALL("all");

    private final String value;

    LadderCommand(final String value) {
        this.value = value;
    }

    public static boolean isAllCommand(final String inputName) {
        return ALL.value.equals(inputName);
    }
}
