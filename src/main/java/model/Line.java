package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();

    private final List<Boolean> points;

    public Line(Width width) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < width.getValue() - 1; i++) {
            result.add(generate(result, i));
        }
        this.points = result;
    }

    private Boolean generate(List<Boolean> points, int index) {
        if (cannotConnect(points, index)) {
            return false;
        }
        return random.nextBoolean();
    }

    private boolean cannotConnect(List<Boolean> points, int index) {
        return index >= 1 && points.get(index - 1);
    }

    public int size() {
        return points.size();
    }

    public boolean isConnected(int index) {
        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
