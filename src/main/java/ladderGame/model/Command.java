package ladderGame.model;

public class Command {
    private final String command;

    public Command(String name, Players players) {
        if(!name.equals("all")) {
            validate(new Name(name), players);
        }

        this.command = name;
    }

    private void validate(Name name, Players players) {
        if(!players.contains(name)) {
            throw new IllegalArgumentException("참여자 목록 중에서 골라야 합니다.");
        }
    }
}
