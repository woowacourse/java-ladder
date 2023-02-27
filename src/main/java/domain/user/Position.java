package domain.user;

import domain.ladder.Line;
import java.util.List;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void movePosition(Line nextLine) {
        List<Boolean> nextLineValues = nextLine.getLine();
        this.position += checkDirection(position, nextLineValues);
    }

    private int checkDirection(int position, List<Boolean> nextLineValues) {
        if (nextLineValues.get(position)) {
            return -1;
        }
        if (position + 1 < nextLineValues.size() && nextLineValues.get(position + 1)) {
            return 1;
        }
        return 0;
    }

    public int getValue() {
        return position;
    }
}
