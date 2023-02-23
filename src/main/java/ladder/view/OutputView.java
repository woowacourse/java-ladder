package ladder.view;

import ladder.domain.Line;
import ladder.domain.Point;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {

    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String NONE = "     ";

    public void showLadderGame(final List<String> players, final List<Line> lines, final List<String> results) {
        System.out.println("사다리 결과");
        printEndLines(players);
        printLadder(lines);
        printEndLines(results);
    }

    private void printLadder(final List<Line> lines) {
        lines.stream()
                .map(this::extractLine)
                .forEach(System.out::println);
    }

    private void printEndLines(final List<String> players) {
        String names = players.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private String extractLine(final Line line) {
        List<Point> points = line.toUnmodifiableLine();
        StringJoiner result = new StringJoiner(VERTICAL, NONE + VERTICAL, VERTICAL);

        for (Point point : points) {
            String pointFormat = toPointFormat(point);
            result.add(pointFormat);
        }
        return result.toString();
    }

    private String toPointFormat(final Point point) {
        if (point == Point.AVAILABLE) {
            return HORIZON;
        }
        return NONE;
    }

    public void showResult(final String product) {
        System.out.println(product);
        
    }
}
