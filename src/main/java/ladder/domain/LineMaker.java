package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    //TODO: 리팩토링
    public static List<Bar> generate(int playerCount, RandomGenerator randomGenerator) {
        List<Bar> line = new ArrayList<>();

        int lineSize = playerCount - 1;
        boolean beforeValue = false;

        for (int idx = 0; idx < lineSize; idx++) {
            Bar currentBar = createBar(beforeValue, randomGenerator);
            line.add(currentBar);
            beforeValue = currentBar.getValue();
        }

        return line;
    }

    private static Bar createBar(boolean beforeValue, RandomGenerator randomGenerator) {
        if(beforeValue) {
            return Bar.UNMOBABLE_BAR;
        }
        return Bar.getBar(randomGenerator.generateBoolean());
    }

}
