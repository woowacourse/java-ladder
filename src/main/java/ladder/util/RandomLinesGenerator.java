package ladder.util;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLinesGenerator {
    public static List<Line> generate(int width, int height) {
        return IntStream.range(0, width)
                .mapToObj(i -> new Line(generateRandomLine(height)))
                .toList();
    }

    private static List<Boolean> generateRandomLine(int count) {
        List<Boolean> result = new ArrayList<>();
        Random random = new Random();

        result.add(random.nextInt(2) == 0);
        IntStream.range(1, count)
                .forEach(i -> result.add(generateRandomScaffold(result.get(i - 1))));

        return result;
    }

    private static Boolean generateRandomScaffold(Boolean previous) {
        if (previous) {
            return false;
        }

        Random random = new Random();
        return random.nextInt(2) == 0;
    }

}
