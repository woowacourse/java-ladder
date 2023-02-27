package domain.player;

import domain.ladder.Line;

public enum MoveType {

    LEFT(-1),
    STAY(0),
    RIGHT(1);

    private final int step;

    MoveType(int step) {
        this.step = step;
    }

    public static MoveType getMoveTypeByPosition(Player player, Line line) {
        int position = player.getPosition();
        if (hasLeftConnection(position, line)) {
            return LEFT;
        }
        if (hasRightConnection(position, line)) {
            return RIGHT;
        }
        return STAY;
    }

    private static boolean hasLeftConnection(int position, Line line) {
        return position != 0 && line.isConnected(position - 1);
    }

    private static boolean hasRightConnection(int position, Line line) {
        return position != line.getLineSize() && line.isConnected(position);
    }

    public int getStep() {
        return step;
    }
}
