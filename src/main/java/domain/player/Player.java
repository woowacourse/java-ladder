package domain.player;

import domain.ladder.Ladder;

public class Player {

    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSameName(String otherName) {
        return name.isSame(otherName);
    }

    public Position move(Ladder ladder) {
        return ladder.play(position);
    }


    public String getName() {
        return name.getName();
    }
}
