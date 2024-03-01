package view;

import domain.Direction;
import domain.Ladder;
import domain.Line;
import domain.Point;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String LINE = "-----";
    private static final String NONE_LINE = "     ";

    private ResultView() {

    }

    public static void printNames(final List<String> names) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-5s", getFirst(names)));
        getMiddle(names).forEach(userName -> stringBuilder.append(String.format("%6s", userName)));
        stringBuilder.append(String.format("%5s", getLast(names)));

        System.out.println(stringBuilder);
    }

    private static List<String> getMiddle(final List<String> names) {
        return names.subList(1, names.size() - 1);
    }

    private static String getLast(final List<String> names) {
        return names.get(names.size() - 1);
    }

    private static String getFirst(final List<String> names) {
        return names.get(0);
    }

    public static void printResultMessage() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLadder().stream()
                .map(ResultView::generateSingleLine)
                .forEach(System.out::println);
    }

    private static String generateSingleLine(final Line line) {
        return "    " + drawLine(line);
    }

    private static String drawLine(final Line line) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Point point : line.getPoints()) {
            stringBuilder.append("|");
            stringBuilder.append(drawPoint(point));
        }
        return stringBuilder.toString();
    }

    private static String drawPoint(final Point point) {
        if (point.getDirection() == Direction.RIGHT) {
            return LINE;
        }
        return NONE_LINE;
    }

    public static void printTargetResultMessage() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printTargetResult(final String result) {
        System.out.println(result);
    }

    public static void printTargetResult(final List<String> names, final List<String> results) {
        IntStream.range(0, names.size())
                .mapToObj(index -> names.get(index) + " : " + results.get(index))
                .forEach(System.out::println);
    }

}
