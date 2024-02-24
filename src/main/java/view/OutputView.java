package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-----";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = " ";
    private static final String NAME_FORMAT = "%6s";
    private static final String RESULT_FORMAT = "%-6s";
    private static final int OFFSET_COUNT = 5;

    private static void printLine(Line line) {
        System.out.print(SPACE.repeat(OFFSET_COUNT));
        System.out.print(VERTICAL_DELIMITER);
        for (Bridge bridge : line.getBridges()) {
            printBridge(bridge);
        }
        System.out.println();
    }

    private static void printBridge(Bridge bridge) {
        if (Bridge.isExist(bridge)) {
            System.out.print(HORIZON_DELIMITER);
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE.repeat(OFFSET_COUNT));
        System.out.print(VERTICAL_DELIMITER);
    }

    public void printLadderGame(Ladder ladder, List<String> names, List<String> results) {
        System.out.println("실행결과\n");
        printPlayer(names);
        printLadder(ladder);
        printResults(results);
    }

    private void printPlayer(List<String> names) {
        names.forEach(name -> System.out.print(String.format(NAME_FORMAT, name)));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printResults(List<String> results) {
        results.forEach(result -> System.out.print(String.format(RESULT_FORMAT, result)));
        System.out.println();
    }
}
