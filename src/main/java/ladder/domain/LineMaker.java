package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    public static List<Boolean> generate(int playerCount, RandomGenerator<Boolean> randomGenerator) {
        List<Boolean> line = new ArrayList<>();
        int lineSize = playerCount - 1;
        boolean before = false;

        for (int idx = 0; idx < lineSize; idx++) {
            boolean current = getBar(before, randomGenerator);
            line.add(current);
            before = current;
        }
        return line;
    }

    private static boolean getBar(boolean before, RandomGenerator<Boolean> randomGenerator) {
        if(before) {
            return false;
        }
        return randomGenerator.generate();
    }

}
