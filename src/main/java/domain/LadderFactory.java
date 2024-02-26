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
        bridges.add(getRandomBridge());
        IntStream.range(1, width)
                .mapToObj(index -> bridges.get(index - 1))
                .forEach(previousBridge -> bridges.add(getCurrentBridgeByPreviousBridge(previousBridge)));
        return bridges;
    }

    private static Bridge getCurrentBridgeByPreviousBridge(final Bridge previousBridge) {
        if (previousBridge.getBridge()) {
            return Bridge.NON_BRIDGE;
        }
        return getRandomBridge();
    }

    private static Bridge getRandomBridge() {
        return Bridge.findByHasLine(RANDOM_GENERATOR.nextBoolean());
    }

}


/*

    final을 꼭 써야할까..

 */
