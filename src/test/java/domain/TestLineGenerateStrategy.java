package domain;

import java.util.List;
import java.util.stream.IntStream;

public class TestLineGenerateStrategy extends AbstractLineGenerateStrategy {
    @Override
    public List<Boolean> generateStrategy(int lineSize) {
        return IntStream.range(0, lineSize)
                .mapToObj(value -> value % 2 == 0)
                .toList();
    }
}
