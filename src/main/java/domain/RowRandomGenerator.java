package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RowRandomGenerator implements RowGenerator {
    private final Random random = new Random();

    public Row generate(int width) {
        return new Row(generateBridges(width, random));
    }

    private Bridges generateBridges(int width, Random random) {
        List<Boolean> rawBridges = IntStream.range(0, width)
                .mapToObj(value -> random.nextBoolean())
                .collect(Collectors.toList());
        fixRawBridges(rawBridges);
        return new Bridges(rawBridges);
    }

    private void fixRawBridges(List<Boolean> rawBridges) {
        IntStream.range(1, rawBridges.size()).forEach(
                index -> {
                    if (rawBridges.get(index) && rawBridges.get(index - 1)) {
                        rawBridges.set(index, false);
                    }
                }
        );
    }
}
