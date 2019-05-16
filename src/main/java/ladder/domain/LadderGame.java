package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private static final int BOUNDARY_CHECK = 1;

    public static Map<String, String> play(Ladder ladder, List<String> names, List<String> items) {
        Map<String, String> result = new HashMap<>();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int i = 0; i < numberOfPeople; i++) {
            result.put(names.get(i), items.get(decidePosition(ladder, i)));
        }

        return result;
    }

    private static int decidePosition(Ladder ladder, int column) {
        int row = 0;

        while (row != ladder.getHeight()) {
            column = moveColumn(ladder, row, column);
            row++;
        }

        return column;
    }

    private static int moveColumn(Ladder ladder, int row, int column) {
        if (ladder.getLine(row).isConnected(column)) {
            return column + 1;
        }
        if (column >= BOUNDARY_CHECK && ladder.getLine(row).isConnected(column - 1)) {
            return column - 1;
        }

        return column;
    }
}
