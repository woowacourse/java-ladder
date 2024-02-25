package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BridgeRandomGenerator implements BridgeGenerator {
    public List<Boolean> generate(int width) {
        Random random = new Random();
        List<Boolean> rawBridges = generateBridges(width, random);
        fixInvalidBridges(width, rawBridges);
        return rawBridges;
    }

    private List<Boolean> generateBridges(int width, Random random) {
        return IntStream.range(0, width)
                .mapToObj(value -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    private void fixInvalidBridges(int width, List<Boolean> rawBridges) {
        for (int index = 1; index < width; index++) {
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
