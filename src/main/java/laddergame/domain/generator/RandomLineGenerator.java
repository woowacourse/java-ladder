package laddergame.domain.generator;

import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line makeLine(int width) {
        List<Boolean> handles = new ArrayList<>();

        handles.add(getConnectableValue(FIRST_VALUE_OF_LINE));
        for (int i = 1; i < width-1; i++) {
            handles.add(getConnectableValue(handles.get(i-1)));
        }

        return new Line(handles);
    }

    private boolean getConnectableValue(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }
}
