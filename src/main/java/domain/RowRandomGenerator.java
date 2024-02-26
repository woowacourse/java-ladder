package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RowRandomGenerator implements RowGenerator {
    private final Random random = new Random();

    private Boolean previousBridge = false;

    public Row generate(int width) {
        return new Row(generateBridges(width, random));
    }

    private Bridges generateBridges(int width, Random random) {
        List<Boolean> rawBridges = IntStream.range(0, width)
                .mapToObj(value -> nextBridge())
                .collect(Collectors.toList());
        return new Bridges(rawBridges);
    }

    private Boolean nextBridge() {
        Boolean newBridge = random.nextBoolean();
        if (newBridge && previousBridge) {
            previousBridge = false;
            return false;
        }
        previousBridge = newBridge;
        return newBridge;
    }
}
