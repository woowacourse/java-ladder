package domain;

import domain.Ladder.Step;

public class Player {

    private final Name name;
    private final Position position;

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(final Step step) {
        step.step(position);
    }

    public Position getPosition(){
        return position;
    }
}
