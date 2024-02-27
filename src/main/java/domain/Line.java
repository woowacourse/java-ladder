package domain;

import utils.Generator;

import java.util.*;

import static domain.Bridge.*;

public class Line {

    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line of(final int personCount, final Generator generator) {
        List<Bridge> bridges = new ArrayList<>();
        generateRandomBridge(bridges, personCount, generator);
        return new Line(bridges);
    }

    public int moveFrom(final int position) {
        return position + findDirection(position);
    }

    private int findDirection(final int position) {
        if (canMoveToRight(position)) {
            return 1;
        }

        if (canMoveToLeft(position)) {
            return -1;
        }

        return 0;
    }

    private boolean canMoveToRight(int position) {
        return position < bridges.size() && bridges.get(position) == BRIDGE;
    }

    private boolean canMoveToLeft(int position) {
        return position != 0 && bridges.get(position - 1) == BRIDGE;
    }

    private static void generateRandomBridge(List<Bridge> bridges, final int personCount, Generator generator) {
        boolean randomLine = generator.generate();
        final Bridge firstBridge = findByHasBridge(randomLine);

        bridges.add(firstBridge);

        for (int i = 1; i < personCount - 1; i++) {
            addBridge(bridges, generator, i);
        }
    }

    private static void addBridge(List<Bridge> bridges, final Generator generator, final int index) {
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
