package ladderGame.view;
import ladderGame.model.input.PlayerNamesInput;
import ladderGame.model.input.ResultsInput;
import ladderGame.model.ladder.Ladder;

import java.util.List;

public class OutputView {
    private static final String EMPTY = "     ";
    private static final String FILLED = "-----";
    private static final String VERTICAL_BAR = "|";

    public static void printLadder(Ladder ladder, List<String> names, List<String> results) {
        System.out.println("\n실행결과\n");
        printNames(names);
        int rows = ladder.getRowNum();
        int columns = ladder.getColumns();
        for (int row = 0; row < rows; row++) {
            System.out.print(EMPTY);
            printLadderRow(ladder, columns, row);
            System.out.println(VERTICAL_BAR);
        }
        printNames(results);
    }

    private static void printLadderRow(Ladder ladder, int columns, int row) {
        for (int column = 0; column < columns; column++) {
            System.out.print(VERTICAL_BAR);
            System.out.print(ladder.getPoint(row, column) ? FILLED : EMPTY);
        }
    }

    public static void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public static void printAllResults(Ladder ladder,
                                       PlayerNamesInput playerNamesInput, ResultsInput resultsInput) {
        System.out.println("\n실행결과");
        for (String playerName : playerNamesInput.getNames()
        ) {
            int startIndex = playerNamesInput.getNames().indexOf(playerName);
            int finishPoint = ladder.getArrivialIndex(startIndex);
            System.out.println(playerName + " : " + resultsInput.getResults().get(finishPoint));
        }

    }

    public static void printOnePlayerResult(Ladder ladder, String name,
                                            PlayerNamesInput playerNamesInput, ResultsInput resultsInput) {
        System.out.println("\n실행결과");
        int startIndex = playerNamesInput.getNames().indexOf(name);
        int arrivialIndex = ladder.getArrivialIndex(startIndex);
        System.out.println(name + " : " + resultsInput.getResults().get(arrivialIndex));
    }
}
