package laddergame.view;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.Result;

public class LadderFormatter {

    private static final String LADDER_HEIGHT_UNIT = "|";
    private static final String LADDER_WIDTH_UNIT = "-";
    private static final String BLANK_UNIT = " ";

    private LadderFormatter() {
    }

    public static String formatLadder(final Result result) {
        final List<String> names = result.names();
        final List<List<Boolean>> ladder = result.ladder();

        final int width = WidthCalculator.calculateWidth(names);
        final int firstWidth = WidthCalculator.calculateFirstWidth(names);

        return ladder.stream()
                .map(line -> BLANK_UNIT.repeat(firstWidth) + formatLine(line, width))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String formatLine(final List<Boolean> points, final int width) {
        return points.stream()
                .map(point -> formatPoint(width, point))
                .collect(Collectors.joining(LADDER_HEIGHT_UNIT, LADDER_HEIGHT_UNIT, LADDER_HEIGHT_UNIT));
    }

    private static String formatPoint(final int width, final Boolean point) {
        if (point) {
            return LADDER_WIDTH_UNIT.repeat(width);
        }
        return BLANK_UNIT.repeat(width);
    }
}
