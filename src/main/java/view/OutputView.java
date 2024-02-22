package view;

import domain.Bridge;
import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {

    private static final String HORIZON_DELIMITER = "-";
    private static final String VERTICAL_DELIMITER = "|";
    private static final String SPACE = " ";

    private static void printLine(List<String> names, Line line, int maxPlayerNameLength) {
        System.out.print(SPACE.repeat(6));
        System.out.print(VERTICAL_DELIMITER);
        for (Bridge bridge : line.getBridges()) {
            printBridge(bridge, maxPlayerNameLength);
        }
        System.out.println();
    }

    private static void printBridge(Bridge bridge, int maxPlayerNameLength) {
        if (bridge == Bridge.EXIST) {
            System.out.print(HORIZON_DELIMITER.repeat(maxPlayerNameLength));
            System.out.print(VERTICAL_DELIMITER);
            return;
        }
        System.out.print(SPACE.repeat(maxPlayerNameLength));
        System.out.print(VERTICAL_DELIMITER);
    }

    public void printResult(Ladder ladder, List<String> names) {
        System.out.println("실행결과\n");
        printPlayer(names);
        printLadder(ladder, names);
    }

    private void printPlayer(List<String> names) {
        names.forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
    }

    private void printLadder(Ladder ladder, List<String> names) {
        List<Line> lines = ladder.getLines();
        int maxPlayerNameLength = names.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow();
        for (Line line : lines) {
            printLine(names, line, maxPlayerNameLength);
        }
    }
}
