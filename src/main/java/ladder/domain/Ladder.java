package ladder.domain;

import java.util.List;
import java.util.Map;

public class Ladder {
    public static Map<String, Integer> goDown(List<Line> lines, Map<String, Integer> positions) {
        for (Line line : lines) {
            goDownOneLine(positions, line);
        }

        return positions;
    }

    private static void goDownOneLine(Map<String, Integer> positions, Line line) {
        for (Map.Entry<String, Integer> entry : positions.entrySet()) {
            int position = entry.getValue();
            entry.setValue(position + line.getDirection(position).getValue());
        }
    }
}
