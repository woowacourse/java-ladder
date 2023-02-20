package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class NonContinuousRandomLineStrategy implements LineStrategy {
    private static final boolean FILLED = true;
    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int sectionCount) {
        List<Boolean> line = makeRandomLine(sectionCount);

        IntStream.range(0, sectionCount - 1).forEach(index -> {
            if (isContinuous(line, index)) {
                makeNoncontinuousLine(line, index);
            }
        });
        return line;
    }

    private static void makeNoncontinuousLine(List<Boolean> line, int index) {
        line.set(index + 1, false);
    }

    private static boolean isContinuous(List<Boolean> line, int index) {
        return line.get(index) == FILLED && line.get(index + 1) == FILLED;
    }

    private List<Boolean> makeRandomLine(int sectionCount) {
        List<Boolean> line = new ArrayList<>();
        for (int i = 0; i < sectionCount; i++) {
            line.add(random.nextBoolean());
        }
        return line;
    }
}
