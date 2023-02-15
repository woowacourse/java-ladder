package view;

import domain.Ladder;
import domain.Line;
import domain.Names;
import domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PASSABLE_POINT = "|-----";
    private static final String BLOCKED_POINT = "|     ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    public void printResult(Names names,
                            Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(getFormattedNames(names));
        List<Line> lines = ladder.getLines();
        int ladderHeight = ladder.getLadderHeight();

        List<List<Point>> rows = initRows(ladderHeight);
        convertLinesToRows(lines, rows);
        printLadder(rows);
    }

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_MESSAGE_PREFIX, message);
    }

    private String getFormattedNames(Names names) {
        return names.getNames().stream()
                .map(name -> String.format("%-5s", name.getName()))
                .collect(Collectors.joining(" "));
    }

    private List<List<Point>> initRows(int ladderHeight) {
        List<List<Point>> rows = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            rows.add(new ArrayList<>());
        }
        return rows;
    }

    private void convertLinesToRows(List<Line> lines, List<List<Point>> rows) {
        for (int index = 0; index < lines.size(); index++) {
            List<Point> points = lines.get(index).getPoints();
            convertLineToRow(rows, points);
        }
    }

    private void convertLineToRow(List<List<Point>> rows, List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            rows.get(i).add(points.get(i));
        }
    }

    private void printLadder(List<List<Point>> rows) {
        for (int index = 0; index < rows.size(); index++) {
            List<Point> row = rows.get(index);
            printEachRow(row);
            System.out.println();
        }
    }

    private void printEachRow(List<Point> row) {
        for (Point point : row) {
            printPoint(point);
        }
    }

    private void printPoint(Point point) {
        if (point.equals(Point.PASSABLE)) {
            System.out.print(PASSABLE_POINT);
            return;
        }
        System.out.print(BLOCKED_POINT);
    }
}
