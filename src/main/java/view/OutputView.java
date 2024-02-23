package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = " ";
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
            System.out.print(HORIZON_DELIMITER.repeat(OFFSET_COUNT));
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE.repeat(OFFSET_COUNT));
        System.out.print(VERTICAL_DELIMITER);
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
}
