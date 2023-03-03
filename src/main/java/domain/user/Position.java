package domain.user;

import java.util.List;

public class Position {
    private static final int LOWER_LEFT_MOVE_INDEX = -1;
    private static final int LOWER_RIGHT_MOVE_INDEX = 1;
    private static final int DIRECT_DOWN_MOVE_INDEX = 0;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void movePosition(List<Boolean> nextLine) {
        this.position += decideMovablePosition(position, nextLine);
    }

    private int decideMovablePosition(int position, List<Boolean> nextLine) {
        if (isLowerLeftMovable(position, nextLine)) {
            return LOWER_LEFT_MOVE_INDEX;
        }
        if (isLowerRightMovable(position, nextLine)) {
            return LOWER_RIGHT_MOVE_INDEX;
        }
        return DIRECT_DOWN_MOVE_INDEX;
    }

    private static boolean isLowerRightMovable(int position, List<Boolean> nextLine) {
        return position + 1 < nextLine.size() && nextLine.get(position + 1);
    }

    private static Boolean isLowerLeftMovable(int position, List<Boolean> nextLine) {
        return nextLine.get(position);
    }

    public int getValue() {
        return position;
    }
}
