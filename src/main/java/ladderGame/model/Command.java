package ladderGame.model;

public class Command {
    private static final String EXCEPTION_MESSAGE_NON_CONTAIN_NAME = "참여자 목록 중에서 골라야 합니다.";
    private static final String COMMAND_ALL = "all";

    private final String command;

    public Command(String command, Players players) {
        if(!command.equals("all")) {
            validate(command, players);
        }

        this.command = command;
    }

    private void validate(String command, Players players) {
        if(!players.contains(new Name(command))) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NON_CONTAIN_NAME);
        }
    }

    public boolean isAll() {
        return COMMAND_ALL.equals(command);
    }

    public Name toName() {
        return new Name(command);
    }
}
