package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class NoncontinuousRandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Step> generate(int sectionCount) {
        List<Step> line = makeRandomLine(sectionCount);

        IntStream.range(0, sectionCount - 1).forEach(index -> {
            if (isContinuous(line, index)) {
                makeNoncontinuousLine(line, index);
            }
        });
        return line;
    }

    private static void makeNoncontinuousLine(List<Step> line, int index) {
        line.set(index + 1, Step.NOT_EXIST);
    }

    private static boolean isContinuous(List<Step> line, int index) {
        return line.get(index).equals(Step.EXIST) && line.get(index + 1).equals(Step.EXIST);
    }

    private List<Step> makeRandomLine(int sectionCount) {
        List<Step> line = new ArrayList<>();
        for (int i = 0; i < sectionCount; i++) {
            boolean randomState = random.nextBoolean();
            line.add(Step.from(randomState));
        }
        return line;
    }
}
