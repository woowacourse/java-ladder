package ladder.util;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLinesGenerator {
    private static Random RANDOM = new Random();

    private RandomLinesGenerator() {
    }

    public static List<Line> generate(int width, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(generateRandomLine(width)))
                .toList();
    }

    private static List<Boolean> generateRandomLine(int count) {
        List<Boolean> line = new ArrayList<>(Collections.nCopies(count, false));

        shuffleOrder(count).forEach(index -> generateRandomScaffold(line, index));

        return Collections.unmodifiableList(line);
    }

    private static List<Integer> shuffleOrder(int count) {
        List<Integer> order = new ArrayList<>(IntStream.range(0, count)
                .boxed()
                .toList());
        Collections.shuffle(order);
        return order;
    }

    private static void generateRandomScaffold(List<Boolean> line, int index) {
        if (isLeftExist(line, index) || isRightExist(line, index)) {
            return;
        }

        line.set(index, RANDOM.nextBoolean());
    }

    private static boolean isLeftExist(List<Boolean> line, int index) {
        return index - 1 >= 0 && line.get(index - 1);
    }

    private static boolean isRightExist(List<Boolean> line, int index) {
        return index + 1 < line.size() && line.get(index + 1);
    }
}
