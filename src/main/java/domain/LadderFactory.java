package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import utils.RandomGenerator;

public class LadderFactory {

    private static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator();

    private LadderFactory() {

    }

    public static Ladder createRandomLadder(final int height, final int width) {
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(generateLine(width)))
                .toList();
        return new Ladder(lines);
    }

    private static List<Bridge> generateLine(int width) {
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(getRandomBridge());
        IntStream.range(1, width)
                .mapToObj(index -> bridges.get(index - 1))
                .forEach(previousBridge -> bridges.add(getCurrentBridgeByPreviousBridge(previousBridge)));
        return bridges;
    }

    private static Bridge getCurrentBridgeByPreviousBridge(Bridge previousBridge) {
        if (previousBridge.getBridge()) {
            return Bridge.NON_BRIDGE;
        }
        return getRandomBridge();
    }

    private static Bridge getRandomBridge() {
        return Bridge.findByHasLine(RANDOM_GENERATOR.generate());
    }

    public static Ladder createLadder(List<Line> lines) {
        return new Ladder(lines);
    }
}
