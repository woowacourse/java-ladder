package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-----";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = "     ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(Ladder ladder, List<String> names) {
        System.out.println("실행결과\n");
        printPlayer(names);
        printLadder(ladder);
    }

    private void printPlayer(List<String> names) {
        names.forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(SPACE);
        System.out.print(VERTICAL_DELIMITER);
        for (Bridge bridge : line.getBridges()) {
            printBridge(bridge);
        }
        System.out.println();
    }

    private void printBridge(Bridge bridge) {
        if (bridge == Bridge.EXIST) {
            System.out.print(HORIZON_DELIMITER);
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE);
        System.out.print(VERTICAL_DELIMITER);
    }
}
