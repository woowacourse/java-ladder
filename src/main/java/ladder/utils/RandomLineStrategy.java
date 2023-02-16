package ladder.utils;

import java.util.*;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int partCount) {
        List<Boolean> line = makeRandomLine(partCount);

        IntStream.range(0, partCount - 1).forEach(i -> {
            if (line.get(i) && line.get(i + 1)) {
                line.set(i + 1, false);
            }
        });
        return line;
    }

    private List<Boolean> makeRandomLine(int partCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < partCount; i++) {
            line.add(random.nextBoolean());
        }
        return line;
    }
}
