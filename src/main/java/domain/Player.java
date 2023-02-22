package domain;

import ui.output.LadderShape;

public class Player {

    private final String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void calculatePosition(String ladderPosition) {
        if (ladderPosition == LadderShape.LEFT.getShape()) {
            position--;
        } else if (ladderPosition == LadderShape.RIGHT.getShape()) {
            position++;
        }
    }
}
