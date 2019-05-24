package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private static boolean FIRST_VALUE_OF_LINE = false;

    protected static Line makeLine(int width) {
        List<Boolean> handles = new ArrayList<>();

        handles.add(getConnectableValue(FIRST_VALUE_OF_LINE));
        for (int i = 1; i < width-1; i++) {
            handles.add(getConnectableValue(handles.get(i-1)));
        }

        return new Line(handles);
    }

    private static boolean getConnectableValue(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }
}
