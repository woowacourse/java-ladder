package ladder.domain;

import java.util.List;

public class Player {
    private final PlayerName name;
    private int position;

    public Player(PlayerName name, int position) {
        this.name = name;
        this.position = position;
    }

    public int tryMove(Steps steps) {
        List<Step> stepList = steps.getSteps();

        if (position == 0) {
            return (stepList.get(position).exist() ? moveRight() : position);
        }
        if (position == stepList.size()) {
            return (stepList.get(position - 1).exist() ? moveLeft() : position);
        }
        if (stepList.get(position - 1).exist()) {
            return moveLeft();
        }
        return (stepList.get(position).exist() ? moveRight() : position);
    }

    private int moveLeft() {
        position--;
        return position;
    }

    private int moveRight() {
        position++;
        return position;
    }

    public PlayerName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
