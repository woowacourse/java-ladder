package domain;

import utils.Generator;

import java.util.*;

public class Line {

    private final List<Bridge> lines = new ArrayList<>();

    public Line(final int personCount, final Generator generator) {
        generateRandomPoint(personCount, generator);
    }


    private void generateRandomPoint(final int personCount, Generator generator) {
        boolean randomLine = generator.generate();
        final Bridge firstBoolean = Bridge.findByHasLine(randomLine);

        lines.add(firstBoolean);

        for (int i = 1; i < personCount - 1; i++) {
            addPoint(generator, i);
        }
    }

    private void addPoint(final Generator generator, final int index) {
        final Bridge before = lines.get(index - 1);
        if (before.getBridge()) {
            lines.add(Bridge.findByHasLine(false));
            return;
        }
        lines.add(Bridge.findByHasLine(generator.generate()));
    }
    public List<Bridge> getPoints() {
        return lines;
    }
}
