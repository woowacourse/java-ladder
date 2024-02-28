package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Stick> sticks = new ArrayList<>();

    public Line(StickGenerator stickGenerator, int playerSize) {
        for (int i = 0; i < playerSize - 1; i++) {
            this.sticks.add(getEmptyStickOrNotRepeatedFilledStick(stickGenerator));
        }
    }

    public int climb(int startPosition) {
        if (this.getRightStick(startPosition) == Stick.FILLED) {
            return startPosition + 1;
        }
        if (this.getLeftStick(startPosition) == Stick.FILLED) {
            return startPosition - 1;
        }

        return startPosition;
    }

    public List<Stick> getSticks() {
        return this.sticks;
    }

    private Stick getEmptyStickOrNotRepeatedFilledStick(StickGenerator stickGenerator) {
        Stick stick = stickGenerator.generateOne();

        if (this.sticks.isEmpty()) {
            return stick;
        }

        if (stick.isFilled() && isRepeat(stick)) {
            return Stick.NOT_FILLED;
        }

        return stick;
    }

    private boolean isRepeat(Stick stick) {
        Stick lastStick = this.sticks.get(this.sticks.size() - 1);

        return lastStick == stick;
    }

    private Stick getRightStick(int position) {
        if (position == this.sticks.size()) {
            return Stick.NOT_FILLED;
        }
        return sticks.get(position);
    }

    private Stick getLeftStick(int position) {
        if (position == 0) {
            return Stick.NOT_FILLED;
        }
        return sticks.get(position - 1);
    }
}
