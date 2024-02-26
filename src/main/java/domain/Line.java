package domain;

import utils.Generator;

import java.util.*;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int personCount, final Generator generator) {
        generateRandomPoint(personCount, generator);
    }


    private void generateRandomPoint(final int personCount, Generator generator) {
        boolean randomLine = generator.generate();
        final Bridge firstBoolean = Bridge.findByHasLine(randomLine);

        bridges.add(firstBoolean);

        for (int i = 1; i < personCount - 1; i++) {
            addPoint(generator, i);
        }
    }

    private void addPoint(final Generator generator, final int index) {
        final Bridge before = bridges.get(index - 1);
        if (before.getBridge()) {
            bridges.add(Bridge.findByHasLine(false));
            return;
        }
        bridges.add(Bridge.findByHasLine(generator.generate()));
    }
    public List<Bridge> getPoints() {
        return bridges;
    }
}
