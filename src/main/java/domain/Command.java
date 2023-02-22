package domain;

public class Command {

    private static final int COMMAND_MIN_SIZE_INCLUSIVE = 1;
    private static final int COMMAND_MAX_SIZE_INCLUSIVE = 5;
    private static final String COMMAND_SIZE_ERROR_MESSAGE = "명령은 1 ~ 5 글자여야 합니다.";
    private static final String ALL_INCLUSIVE = "all";

    private final String command;

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        if (isOutOfRange(command)) {
            throw new IllegalArgumentException(COMMAND_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(String command) {
        return !(COMMAND_MIN_SIZE_INCLUSIVE <= command.length()
                && command.length() <= COMMAND_MAX_SIZE_INCLUSIVE);
    }

    public boolean isAllCommand() {
        return command.equals(ALL_INCLUSIVE);
    }

    public boolean isCommandMatches(Player player) {
        return player.getName()
                .equals(this.command);
    }

}
