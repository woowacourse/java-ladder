package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    public static List<Bar> generate(int playerCount, BooleanGenerator booleanGenerator) {
        int lineSize = playerCount - 1;
        List<Bar> line = new ArrayList<>();

        boolean beforeValue = false;

        for (int idx = 0; idx < lineSize; idx++) {
            Bar currentBar = createBar(beforeValue, booleanGenerator);
            line.add(currentBar);
            beforeValue = currentBar.getValue();
        }

        return line;
    }

    private static Bar createBar(boolean beforeValue, BooleanGenerator booleanGenerator) {
        if (beforeValue) {
            return Bar.UNMOVABLE_BAR;
        }

        return Bar.getBar(booleanGenerator.generateBoolean());
    }

}
