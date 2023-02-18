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
    private static final String BAR_EXIST = "-----";
    private static final String BAR_NONE = "     ";
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
        List<Boolean> bars = line.toUnmodifiableBars();
        StringJoiner result = new StringJoiner(VERTICAL, BAR_NONE + VERTICAL, VERTICAL);

        for (Boolean bar : bars) {
            String pointFormat = toBarFormat(bar);
            result.add(pointFormat);
        }
        return result.toString();
    }

    private static String toBarFormat(Boolean bar) {
        if (bar) {
            return BAR_EXIST;
        }
        return BAR_NONE;
    }
}
