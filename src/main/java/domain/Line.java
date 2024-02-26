package domain;

import utils.Generator;

import java.util.*;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int personCount, final Generator generator) {
        generateRandomBridge(personCount, generator);
    }


    private void generateRandomBridge(final int personCount, Generator generator) {
        boolean randomLine = generator.generate();
        final Bridge firstBridge = Bridge.findByHasBridge(randomLine);

        bridges.add(firstBridge);

        for (int i = 1; i < personCount - 1; i++) {
            addBridge(generator, i);
        }
    }

    private void addBridge(final Generator generator, final int index) {
        final Bridge before = bridges.get(index - 1);
        if (before.getBridge()) {
            bridges.add(Bridge.NON_BRIDGE);
            return;
        }
        bridges.add(Bridge.findByHasBridge(generator.generate()));
    }
    public List<Bridge> getPoints() {
        return bridges;
    }
}
