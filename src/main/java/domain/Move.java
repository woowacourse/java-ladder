package domain;

public enum Move {
    LEFT(-1), STAY(0), RIGHT(1);

    final int distance;

    public int newPosition(int position) {
        return position + this.distance;
    }

    Move(int distance) {
        this.distance = distance;
    }

    public static Move get(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return STAY;
    }
}
