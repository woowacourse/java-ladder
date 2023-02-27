package domain.user;

import java.util.List;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void movePosition(List<Boolean> nextLine) {
        this.position += checkDirection(position, nextLine);
    }

    private int checkDirection(int position, List<Boolean> nextLine) {
        if (nextLine.get(position)) {
            return -1;
        }
        if (position + 1 < nextLine.size() && nextLine.get(position + 1)) {
            return 1;
        }
        return 0;
    }

    public int getValue() {
        return position;
    }
}
