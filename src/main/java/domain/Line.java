package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Stick> sticks;

    public Line(StickGenerator stickGenerator, int playerSize) {
        List<Stick> sticks = new ArrayList<>();

        for (int i = 0; i < playerSize - 1; i++) {
            sticks.add(getStick(stickGenerator, sticks));
        }

        this.sticks = sticks;
    }

    private Stick getStick(StickGenerator stickGenerator, List<Stick> sticks) {
        Stick stick = stickGenerator.generateOne();
        if (!sticks.isEmpty() && sticks.get(sticks.size() - 1) == stick) {
            if (stick == Stick.FILLED) {
                return Stick.getOpposite(stick);
            }
        }

        return stick;
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
