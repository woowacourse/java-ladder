package ladder.domain;

import java.util.List;

public class Player {
    private final PlayerName name;
    private int position;

    public Player(PlayerName name, int position) {
        this.name = name;
        this.position = position;
    }

    public int tryMove(List<Boolean> points) {
        if (position == 0) {
            return (points.get(position) ? moveRight() : position);
        }
        if (position == points.size()) {
            return (points.get(position - 1) ? moveLeft() : position);
        }
        if (points.get(position - 1)) {
            return moveLeft();
        }
        return (points.get(position) ? moveRight() : position);
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
