package domain;

import java.util.*;

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
            addPoint(generator, i);
        }
    }

    private void addPoint(Generator generator, int i) {
        boolean before = points.get(i - 1);
        if (before == true) {
            points.add(false);
            return;
        }
        points.add(generator.generate());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
