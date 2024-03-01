package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineMakeStrategy {
    private final int lineSize;

    public RandomLineMakeStrategy(int lineSize) {
        this.lineSize = lineSize;
    }

    public Boolean[] makeLine() {
        return generateBridges(new Random());
    }

    private Boolean[] generateBridges(Random random) {
        List<Boolean> randomBooleans = IntStream.range(0, lineSize - 1)
                .mapToObj(value -> random.nextBoolean())
                .collect(Collectors.toList());
        fixInvalidBridges(randomBooleans);
        randomBooleans.add(false);
        return randomBooleans.toArray(Boolean[]::new);
    }

    private void fixInvalidBridges(List<Boolean> rawBridges) {
        for (int index = 1; index < lineSize - 1; index++) {
            fixIfNeed(rawBridges, index);
        }
    }

    private void fixIfNeed(List<Boolean> rawBridges, int index) {
        if (isBridgeInARow(rawBridges, index)) {
            rawBridges.set(index, false);
        }
    }

    private boolean isBridgeInARow(List<Boolean> rawBridges, int index) {
        return rawBridges.get(index) && rawBridges.get(index - 1);
    }
}
