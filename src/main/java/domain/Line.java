package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    List<Boolean> points = new ArrayList<>();

    public Line() {
    }

    public Line(int personCount) {
        for (int i = 0; i < personCount-1; i++) {
            points.add(false);
        }
    }

    public List<Boolean> generateRandomPoint() {
        Collections.fill(points, true);
        return points;
    }
}
