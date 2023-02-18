package ladder.utils;

import java.util.*;
import java.util.stream.IntStream;

public class RandomDiscreteStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int sectionCount) {
        List<Boolean> line = makeRandomLine(sectionCount);

        IntStream.range(0, sectionCount - 1)
                .forEach(idx -> {convertDiscontinuous(line, idx);});
        return line;
    }

    private void convertDiscontinuous(List<Boolean> line, int idx) {
        if (isContinuous(line, idx)) {
            line.set(idx + 1, false);
        }
    }

    public boolean isContinuous(List<Boolean> line, int idx) {
        return line.get(idx) && line.get(idx + 1);
    }

    private List<Boolean> makeRandomLine(int sectionCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < sectionCount; i++) {
            line.add(random.nextBoolean());
        }
        return line;
    }
}
