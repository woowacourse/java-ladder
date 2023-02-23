package domain.player;

import domain.ladder.Line;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isLeftSidePassable(Line line) {
        return !isLeftEnd() && line.isLeftPointPassableBySpecificPosition(position);
    }

    private boolean isLeftEnd() {
        return position == 1;
    }

    public boolean isRightSidePassable(Line line) {
        return !isRightEnd(line.getLastPosition()) && line.isRightPointPassableBySpecificPosition(position);
    }

    private boolean isRightEnd(int rightEnd) {
        return position == rightEnd;
    }

    public void moveRight() {
        position++;
    }

    public void moveLeft() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}
