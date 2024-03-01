package ladderGame.model;

public class Command {
    private static final String COMMAND_ALL = "all";

    private final String command;

    public Command(String command, Players players) {
        if(!COMMAND_ALL.equals(command)) {
            validate(command, players);
        }

        this.command = command;
    }

    private void validate(String command, Players players) {
        if(!players.contains(new Name(command))) {
            throw new IllegalArgumentException("참여자 목록 중에서 골라야 합니다.");
        }
    }

    public boolean isAll() {
        return COMMAND_ALL.equals(command);
    }

    public Name toName() {
        return new Name(command);
    }
}
