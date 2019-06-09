package ladderGame.view;

import ladderGame.model.ladder.Ladder;
import ladderGame.model.ladder.direction.Direction;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String EMPTY = "     ";
    private static final String FILLED = "-----";
    private static final String VERTICAL_BAR = "|";

    public static void printLadder(Ladder ladder, List<String> playerNames, List<String> resultNames) {
        System.out.println("\n실행결과\n");
        printNames(playerNames);
        int rows = ladder.getRowNumber();
        int columns = ladder.getColumnNumber();
        for (int row = 0; row < rows; row++) {
            System.out.print(EMPTY);
            printLadderRow(ladder, columns, row);
        }
        printNames(resultNames);
    }

    private static void printLadderRow(Ladder ladder, int columns, int row) {
        for (int column = 0; column < columns; column++) {
            System.out.print(VERTICAL_BAR);
            System.out.print(ladder.getDirection(row, column) == Direction.RIGHT ? FILLED : EMPTY);
        }
        System.out.println();
    }

    public static void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public static void printAllResults(Map<String, String> result) {
        System.out.println("\n실행결과");
        for (String player : result.keySet()) {
            System.out.println(player + " : " + result.get(player));
        }
    }

    public static void printOnePlayerResult(Map<String, String> result, String player) {
        System.out.println("\n실행결과");
        System.out.println(player + " : " + result.get(player));
    }
}
