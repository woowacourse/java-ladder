package laddergame.domain.players;

public class Player {

    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getValue();
    }
}
