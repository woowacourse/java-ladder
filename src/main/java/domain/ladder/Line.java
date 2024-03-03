package domain.ladder;

import domain.ladder.stick.Stick;

import java.util.List;

public class Line {

    private final List<Stick> sticks;

    public Line(List<Stick> sticks) {
        this.sticks = sticks;
    }

    public int climb(int startPosition) {
        if (this.checkRightStickFilled(startPosition)) {
            return startPosition + 1;
        }
        if (this.checkLeftStickFilled(startPosition)) {
            return startPosition - 1;
        }

        return startPosition;
    }

    public List<Stick> getSticks() {
        return this.sticks;
    }

    private boolean checkRightStickFilled(int position) {
        if (position == this.sticks.size()) {
            return false;
        }
        return sticks.get(position) == Stick.FILLED;
    }

    private boolean checkLeftStickFilled(int position) {
        if (position == 0) {
            return false;
        }
        return sticks.get(position - 1) == Stick.FILLED;
    }
}
