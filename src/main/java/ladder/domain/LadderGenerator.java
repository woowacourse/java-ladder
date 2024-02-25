package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGenerator {
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

    private static boolean existLeft(List<Boolean> line, int index) {
        return index - 1 >= 0 && line.get(index - 1);
    }

    private static boolean existRight(List<Boolean> line, int index) {
        return index + 1 < line.size() && line.get(index + 1);
    }

    private static Line generateRandomLine(int count) {
        List<Boolean> scaffolds = new ArrayList<>(Collections.nCopies(count, false));
        shuffleOrder(count).forEach(index -> generateRandomScaffold(scaffolds, index));
        return new Line(scaffolds);
    }

    private static void generateRandomScaffold(List<Boolean> line, int index) {
        if (existLeft(line, index) || existRight(line, index)) {
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
