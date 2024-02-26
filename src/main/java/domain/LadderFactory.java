package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderFactory {

    private static final Random RANDOM_GENERATOR = new Random();

    private LadderFactory() {

    }

    public static Ladder createLadder(final List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder createRandomLadder(final int height, final int width) {
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(generateLine(width)))
                .toList();
        return createLadder(lines);
    }

    private static List<Bridge> generateLine(final int width) {
        final List<Bridge> bridges = new ArrayList<>();
        bridges.add(nextRandomBridge());
        IntStream.range(1, width)
                .mapToObj(index -> bridges.get(index - 1))
                .forEach(previousBridge -> bridges.add(calculateCurrentBridgeByPreviousBridge(previousBridge)));
        return bridges;
    }

    private static Bridge calculateCurrentBridgeByPreviousBridge(final Bridge previousBridge) {
        if (previousBridge.isConnected()) {
            return Bridge.NON_BRIDGE;
        }
        return nextRandomBridge();
    }

    private static Bridge nextRandomBridge() {
        return Bridge.findByConnection(RANDOM_GENERATOR.nextBoolean());
    }
}
