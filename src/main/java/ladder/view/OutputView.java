package ladder.view;

import ladder.domain.StepStatus;
import ladder.dto.LadderResult;
import ladder.dto.LineResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(makeNameMessage(ladderResult.names()));
        System.out.println(drawRadder(ladderResult.lines()));
    }

    private static String makeNameMessage(final List<String> userNames) {
        return String.join(" ", makeName(userNames.size(), userNames));
    }

    private static String makeName(final int end, final List<String> userNames) {
        return IntStream.range(0, end)
                .mapToObj(i -> formatName(userNames.get(i)))
                .collect(Collectors.joining(" "));
    }

    private static String formatName(final String name) {
        return String.format("%5s", name);
    }

    private static String drawRadder(final List<LineResult> lineResults) {
        return lineResults.stream()
                .map(OutputView::drawLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String drawLine(LineResult lineResult) {
        String prefix = "    |";
        String steps = lineResult.value()
                .stream()
                .map(OutputView::drawStep)
                .collect(Collectors.joining());
        return prefix + steps;
    }

    private static String drawStep(StepStatus stepStatus) {
        if (stepStatus.isExist()) {
            return "-----|";
        }
        return "     |";
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
