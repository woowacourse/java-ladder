package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.StepStatus;
import ladder.dto.AllResults;
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
        System.out.println(makeLadderMessages(ladder.names()));
        System.out.println(drawLadder(ladder.lines()));
        System.out.println(makeLadderMessages(ladder.destinations()));
    }

    private static String makeLadderMessages(final List<String> messages) {
        return messages.stream()
                .map(OutputView::formatMessage)
                .collect(Collectors.joining(SPACE));
    }

    private static String formatMessage(final String message) {
        return String.format("%5s", message);
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

    public static void printOneResult(final String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printAllResults(final List<AllResults> results) {
        System.out.println("실행 결과");
        System.out.println(makeResultMessage(results));
        System.out.println();
    }

    private static String makeResultMessage(final List<AllResults> results) {
        return results.stream()
                .map(result -> String.join(" : ", result.name(), result.destination()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
