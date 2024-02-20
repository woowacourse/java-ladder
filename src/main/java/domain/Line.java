package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    List<Boolean> points = new ArrayList<>();

    public Line() {
    }

    public Line(int personCount, Generator generator) {
        generateRandomPoint(personCount, generator);
    }


    private void generateRandomPoint(int personCount, Generator generator) {
        boolean firstBoolean = generator.generate();

        points.add(firstBoolean);

        for (int i = 1; i < personCount - 1; i++) {
            boolean before = points.get(i - 1);
            if (before == true) {
                points.add(false);
                continue;
            }
            points.add(generator.generate());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
