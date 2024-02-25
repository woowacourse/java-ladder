package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.StepStatus;
import ladder.dto.Ladder;
import ladder.dto.LineResult;

public class OutputView {
    private static final String SPACE = " ";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(makeNameMessage(ladder.names()));
        System.out.println(drawLadder(ladder.lines()));
    }

    private static String makeNameMessage(final List<String> userNames) {
        return String.join(SPACE, makeName(userNames.size(), userNames));
    }

    private static String makeName(final int end, final List<String> userNames) {
        return IntStream.range(0, end)
                .mapToObj(i -> formatName(userNames.get(i)))
                .collect(Collectors.joining(SPACE));
    }

    private static String formatName(final String name) {
        return String.format("%5s", name);
    }

    private static String drawLadder(final List<LineResult> lineResults) {
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
