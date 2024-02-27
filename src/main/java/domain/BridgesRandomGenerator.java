package domain;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgesRandomGenerator implements BridgesGenerator {
    private final Random random = new Random();
    private Boolean previousBridge = false;

    public Bridges generate(int width) {
        return new Bridges(IntStream.range(0, width)
                .mapToObj(value -> nextBridge())
                .collect(Collectors.toList()));
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
