package laddergame.view;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.Result;

public class LadderFormatter {

    private LadderFormatter() {
    }

    public static String formatLadder(final Result result) {
        final List<String> names = result.names();
        final List<List<Boolean>> ladder = result.ladder();

        final int width = WidthCalculator.calculateWidth(names);
        final int firstWidth = WidthCalculator.calculateFirstWidth(names);

        return ladder.stream()
                .map(line -> " ".repeat(firstWidth) + formatLine(line, width))
                .collect(Collectors.joining("\n"));
    }

    private static String formatLine(final List<Boolean> points, final int width) {
        return points.stream()
                .map(point -> formatPoint(width, point))
                .collect(Collectors.joining("|", "|", "|"));
    }

    private static String formatPoint(final int width, final Boolean point) {
        if (point) {
            return "-".repeat(width);
        }
        return " ".repeat(width);
    }
}
