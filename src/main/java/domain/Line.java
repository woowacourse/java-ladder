package domain;

import java.util.*;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(final int personCount, final Generator generator) {
        generateRandomPoint(personCount, generator);
    }


    private void generateRandomPoint(final int personCount, Generator generator) {
        final boolean firstBoolean = generator.generate();

        points.add(firstBoolean);

        for (int i = 1; i < personCount - 1; i++) {
            addPoint(generator, i);
        }
    }

    private void addPoint(final Generator generator, final int index) {
        final boolean before = points.get(index - 1);
        if (before) {
            points.add(false);
            return;
        }
        points.add(generator.generate());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
