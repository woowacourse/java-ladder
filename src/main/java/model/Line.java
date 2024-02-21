package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();

    private final List<Boolean> points;

    public Line(int personCount) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < personCount - 1; i++) {
            result.add(generate(result, i));
        }
        this.points = result;
    }

    private Boolean generate(List<Boolean> points, int index) {
        if(index > 1 && points.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
