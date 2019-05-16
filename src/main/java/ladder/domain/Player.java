package ladder.domain;

import java.util.List;

public class Player {
    private String name;
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

    public int trymove(List<Boolean> points) {
        if (position == 0) {
            return (points.get(position) ? moveRight() : position);
        }
        if (position == points.size()) {
            return (points.get(position - 1) ? moveLeft() : position);
        }
        if (points.get(position - 1)) {
            return moveLeft();
        }
        return moveRight();
    }

    private int moveLeft() {
        position--;
        return position;
    }

    private int moveRight() {
        position++;
        return position;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }


}
