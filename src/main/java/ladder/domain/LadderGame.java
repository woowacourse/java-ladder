package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int BOUNDARY_CHECK = 1;

    public static List<Integer> play(Ladder ladder) {
        List<Integer> result = new ArrayList<>();
        int numberOfPeople = ladder.getNumberOfPeople();

        for (int i = 0; i < numberOfPeople; i++) {
            result.add(decidePosition(ladder, i));
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
        if (column < ladder.getNumberOfPeople() - 1 && ladder.getLine(row).isConnected(column)) {
            return column + 1;
        }
        if (column >= BOUNDARY_CHECK && ladder.getLine(row).isConnected(column - 1)) {
            return column - 1;
        }

        return column;
    }
}
