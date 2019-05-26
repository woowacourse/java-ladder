package ladder.domain.gamecomponent;

import ladder.domain.laddercomponent.Steps;

public class Player {
    private final PlayerName name;
    private Position position;

    public Player(PlayerName name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move(Steps steps) {
        position.judgeMove(steps);
    }

    public PlayerName getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

}
