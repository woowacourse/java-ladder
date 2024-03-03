package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public final class RandomLineGenerateStrategy extends AbstractLineGenerateStrategy {
    @Override
    public List<Boolean> generateStrategy(int lineSize) {
        Random random = new Random();
        return IntStream.range(0, lineSize)
                .mapToObj(value -> random.nextBoolean())
                .toList();
    }
}
