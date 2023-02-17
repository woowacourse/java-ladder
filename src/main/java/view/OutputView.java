package view;

import domain.Ladder;
import domain.Line;
import domain.Names;
import domain.Point;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "-----";
    private static final String BLOCKED_POINT = "     ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printResult(Names names,
                            Ladder ladder) {
        System.out.println("실행결과");

        System.out.println(getFormattedNames(names));
        printLadder(ladder);
    }

    private String getFormattedNames(Names names) {
        return names.stream()
                .map(name -> String.format("%-5s", name.getName()))
                .collect(Collectors.joining(" "));
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        line.getPoints().forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(Point point) {
        if (point.equals(Point.PASSABLE)) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
