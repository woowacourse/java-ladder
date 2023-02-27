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
        if (nextLineValues.get(position)) {
            this.position--;
        }
        else if (position + 1 < nextLineValues.size() && nextLineValues.get(position + 1)) {
            this.position++;
        }
    }

    public int getValue() {
        return position;
    }
}
