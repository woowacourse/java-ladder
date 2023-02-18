package ladder.utils;

import java.util.*;
import java.util.stream.IntStream;

public class NonContinuousRandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int sectionCount) {
        List<Boolean> line = makeRandomLine(sectionCount);

        IntStream.range(0, sectionCount - 1).forEach(i -> {
            if (line.get(i) && line.get(i + 1)) {
                line.set(i + 1, false);
            }
        });
        return line;
    }

    private List<Boolean> makeRandomLine(int sectionCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < sectionCount; i++) {
            line.add(random.nextBoolean());
        }
        return line;
    }
}
