package domain;

import utils.Generator;

import java.util.*;

import static domain.Bridge.*;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int personCount, final Generator generator) {
        generateRandomBridge(personCount, generator);
    }

    public Line(final List<Bridge> bridges) {
        this.bridges.addAll(bridges);
    }

    public int moveFrom(final int position) {
        return position + findDirection(position);
    }

    private int findDirection(final int position) {
        if (position < bridges.size() && bridges.get(position) == BRIDGE) {
            return 1;
        }

        if (position != 0 && bridges.get(position - 1) == BRIDGE) {
            return -1;
        }

        return 0;
    }


    private void generateRandomBridge(final int personCount, Generator generator) {
        boolean randomLine = generator.generate();
        final Bridge firstBridge = findByHasBridge(randomLine);

        bridges.add(firstBridge);

        for (int i = 1; i < personCount - 1; i++) {
            addBridge(generator, i);
        }
    }

    private void addBridge(final Generator generator, final int index) {
        final Bridge before = bridges.get(index - 1);
        if (before.getBridge()) {
            bridges.add(NON_BRIDGE);
            return;
        }
        bridges.add(findByHasBridge(generator.generate()));
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
