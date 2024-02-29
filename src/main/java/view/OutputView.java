package view;

import constant.PathStatus;
import dto.LadderGameResultDto;
import dto.LadderStatus;
import dto.PathStatuses;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printLadderResult(final LadderStatus ladderStatus) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(makeNameMessage(ladderStatus.playerNames()));
        System.out.println(drawRadder(ladderStatus.pathStatuses()));
        System.out.println(makeGameResultMessage(ladderStatus.gameResults()));
        System.out.println();
    }

    private static String makeNameMessage(final List<String> userNames) {
        int userNamesCount = userNames.size();
        String s1 = makeName(0, userNamesCount - 1, "%-5s", userNames);
        String s2 = makeName(userNamesCount - 1, userNamesCount, "%5s", userNames);
        return String.join(" ", s1, s2);
    }

    private static String formatName(final String type, final String name) {
        return String.format(type, name);
    }

    private static String makeName(final int start, final int end, final String type, final List<String> userNames) {
        return IntStream.range(start, end)
                .mapToObj(i -> formatName(type, userNames.get(i)))
                .collect(Collectors.joining(" "));
    }

    private static String drawRadder(final List<PathStatuses> pathStatuses) {
        return pathStatuses.stream()
                .map(OutputView::drawLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String drawLine(final PathStatuses pathStatuses) {
        String prefix = "    |";
        String steps = pathStatuses.pathStatuses()
                .stream()
                .map(OutputView::drawStep)
                .collect(Collectors.joining());
        return prefix + steps;
    }

    private static String drawStep(final PathStatus pathStatus) {
        if (pathStatus.isExist()) {
            return "-----|";
        }
        return "     |";
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    private static String makeGameResultMessage(final List<String> gameResults) {
        int gameResultsSize = gameResults.size();
        return makeName(0, gameResultsSize, "%-5s", gameResults);
    }

    public static void printLadderGameResults(final List<LadderGameResultDto> ladderGameResults) {
        System.out.println();
        System.out.println("실행 결과");
        if (ladderGameResults.size() == 1) {
            System.out.println(ladderGameResults.get(0).gameResult());
            System.out.println();
            return;
        }
        ladderGameResults.forEach(OutputView::printLadderGameResult);
        System.out.println();
    }

    private static void printLadderGameResult(final LadderGameResultDto ladderGameResult) {
        System.out.println(ladderGameResult.playerName() + " : " + ladderGameResult.gameResult());
    }
}
