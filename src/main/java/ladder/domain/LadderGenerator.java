package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGenerator {
    // TODO: 테스트 코드 작성
    private static final Random RANDOM = new Random();
    private final int width;
    private final int height;

    public LadderGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static List<Integer> shuffleOrder(int count) {
        List<Integer> order = new ArrayList<>(IntStream.range(0, count)
                .boxed()
                .toList());
        Collections.shuffle(order);
        return order;
    }

    private static boolean existPrevious(List<Boolean> line, int index) {
        boolean isNotFirstIndex = index != 0;
        Boolean existPrevious = line.get(index - 1);
        return isNotFirstIndex && existPrevious;
    }

    private static boolean existNext(List<Boolean> line, int index) {
        boolean isNotLastIndex = index + 1 != line.size();
        Boolean existNext = line.get(index + 1);
        return isNotLastIndex && existNext;
    }

    private static Line generateRandomLine(int count) {
        List<Boolean> scaffolds = new ArrayList<>(Collections.nCopies(count, false));
        shuffleOrder(count).forEach(index -> generateRandomScaffold(scaffolds, index));
        return new Line(scaffolds);
    }

    private static void generateRandomScaffold(List<Boolean> line, int index) {
        if (existPrevious(line, index) || existNext(line, index)) {
            return;
        }
        line.set(index, RANDOM.nextBoolean());
    }


    public Ladder generate() {
        return new Ladder(Stream.generate(() -> generateRandomLine(width))
                .limit(height)
                .toList());
    }
}
