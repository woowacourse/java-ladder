package ladder.view;

import ladder.constant.PathStatus;
import ladder.dto.LadderStatus;
import ladder.dto.PathStatuses;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printLadderResult(LadderStatus ladderStatus) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(makeNameMessage(ladderStatus.playerNames()));
        System.out.println(drawRadder(ladderStatus.pathStatuses()));
    }

    private static String makeNameMessage(List<String> userNames) {
        int userNamesCount = userNames.size();
        String s1 = makeName(0, userNamesCount - 1, "%-5s", userNames);
        String s2 = makeName(userNamesCount - 1, userNamesCount, "%5s", userNames);
        return String.join(" ", s1, s2);
    }

    private static String formatName(String type, String name) {
        return String.format(type, name);
    }

    private static String makeName(int start, int end, String type, List<String> userNames) {
        return IntStream.range(start, end)
                .mapToObj(i -> formatName(type, userNames.get(i)))
                .collect(Collectors.joining(" "));
    }

    private static String drawRadder(List<PathStatuses> pathStatuses) {
        return pathStatuses.stream()
                .map(OutputView::drawLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String drawLine(PathStatuses pathStatuses) {
        String prefix = "    |";
        String steps = pathStatuses.pathStatuses()
                .stream()
                .map(OutputView::drawStep)
                .collect(Collectors.joining());
        return prefix + steps;
    }

    private static String drawStep(PathStatus pathStatus) {
        if (pathStatus.isExist()) {
            return "-----|";
        }
        return "     |";
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
