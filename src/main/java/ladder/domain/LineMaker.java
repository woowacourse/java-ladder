package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {

    public static List<Bar> generate(int playerCount, ValueGenerator valueGenerator) {
        int lineSize = playerCount - 1;
        List<Bar> line = new ArrayList<>();

        boolean beforeValue = false;

        for (int idx = 0; idx < lineSize; idx++) {
            Bar currentBar = createBar(beforeValue, valueGenerator);
            line.add(currentBar);
            beforeValue = currentBar.getValue();
        }

        return line;

    }

    private static Bar createBar(boolean beforeValue, ValueGenerator valueGenerator) {
        if (beforeValue) {
            return Bar.UNMOVABLE_BAR;
        }
        return Bar.getBar(valueGenerator.generateBoolean());
    }

}
