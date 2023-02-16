package ladder.view;


import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import ladder.domain.Line;

/*
 * pobi  honux crong   jk
 *     |-----|     |-----|
 *     |     |-----|     |
 *     |-----|     |     |
 *     |     |-----|     |
 *     |-----|     |-----|
 */
public class OutputView {

    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String NONE = "     ";
    private static final String MESSAGE_GAME_RESULT = "실행 결과";

    public static void showGameResult(List<String> players, List<Line> lines) {
        String result = players.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());

        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println(result);
        lines.stream()
                .map(OutputView::extractLine)
                .forEach(System.out::println);
    }

    private static String extractLine(Line line) {
        List<Boolean> points = line.toUnmodifiableBars();
        StringJoiner result = new StringJoiner(VERTICAL, NONE + VERTICAL, VERTICAL);

        for (Boolean point : points) {
            String pointFormat = toPointFormat(point);
            result.add(pointFormat);
        }
        return result.toString();
    }

    private static String toPointFormat(Boolean point) {
        if (point) {
            return HORIZON;
        }
        return NONE;
    }
}
