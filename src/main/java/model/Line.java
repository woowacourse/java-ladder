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
            result.add(generate());
        }
        this.points = result;
    }

    private Boolean generate() {
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
