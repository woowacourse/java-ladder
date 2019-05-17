package ladderGame.view;
import ladderGame.dto.DrawnLadder;
import ladderGame.model.input.PlayerNamesInput;
import ladderGame.model.input.ResultsInput;
import ladderGame.model.ladder.LadderNavigator;
import java.util.List;

public class OutputView {
    private static final String EMPTY = "     ";
    private static final String FILLED = "-----";
    private static final String VERTICAL_BAR = "|";

    public static void printLadder(DrawnLadder drawnladder, List<String> names, List<String> results) {
        System.out.println("\n실행결과\n");
        printNames(names);
        int rows = drawnladder.getRows();
        int columns = drawnladder.getColumns();
        for (int row = 0; row < rows; row++) {
            System.out.print(EMPTY);
            printLadderRow(drawnladder, columns, row);
            System.out.println(VERTICAL_BAR);
        }
        printNames(results);
    }

    private static void printLadderRow(DrawnLadder drawnladder, int columns, int row) {
        for (int column = 0; column < columns; column++) {
            System.out.print(VERTICAL_BAR);
            System.out.print(drawnladder.isDrawn(row, column) ? FILLED : EMPTY);
        }
    }

    public static void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    public static void printAllResults(DrawnLadder drawnLadder,
                                       PlayerNamesInput playerNamesInput, ResultsInput resultsInput) {
        System.out.println("\n실행결과");
        for (String playerName : playerNamesInput.getNames()
             ) {
            int startPoint = playerNamesInput.getNames().indexOf(playerName);
            int finishPoint = LadderNavigator.navigate(drawnLadder, startPoint);
            System.out.println(playerName + " : " + resultsInput.getResults().get(finishPoint));
        }

    }

    public static void printOnePlayerResult(DrawnLadder drawnLadder, String name,
                                            PlayerNamesInput playerNamesInput, ResultsInput resultsInput) {
        System.out.println("\n실행결과");
        int startPoint = playerNamesInput.getNames().indexOf(name);
        int finishPoint = LadderNavigator.navigate(drawnLadder, startPoint);
        System.out.println(name + " : " + resultsInput.getResults().get(finishPoint));
    }
}
