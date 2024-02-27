package ladderGame.model;

public class WantedName {
    private final String name;

    public WantedName(String name, Players players) {
        if(!name.equals("all")) {
            validate(new Name(name), players);
        }

        this.name = name;
    }

    private void validate(Name name, Players players) {
        if(!players.contains(name)) {
            throw new IllegalArgumentException("참여자 목록 중에서 골라야 합니다.");
        }
    }
}
