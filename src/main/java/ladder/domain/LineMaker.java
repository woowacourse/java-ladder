package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    public static List<Bar> generate(int playerCount, RandomGenerator<Boolean> randomGenerator) {
        List<Bar> line = new ArrayList<>();
        int lineSize = playerCount - 1;
        boolean beforeValue = false;

        for (int idx = 0; idx < lineSize; idx++) {
            Bar currentBar = getBar(beforeValue, randomGenerator);
            line.add(currentBar);
            beforeValue = currentBar.getValue();
        }
        return line;
    }

    private static Bar getBar(boolean beforeValue, RandomGenerator<Boolean> randomGenerator) {
        if(beforeValue) {
            return new Bar(false);
        }
        return new Bar(randomGenerator.generate());
    }

}
