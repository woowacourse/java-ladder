package ladder.view;

import ladder.domain.Bar;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.PlayerNames;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int PER_NAME_SPACE = 6;

    public static void printNames(PlayerNames playerNames) {
        println(parseDisplayNames(playerNames.getNames()));
    }

    private static String parseDisplayNames(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(nameIndex -> parseDisplayName(names, nameIndex))
                .collect(Collectors.joining());
    }

    private static String parseDisplayName(List<String> names, int nameIndex) {
        if (nameIndex == 0) {
            return names.get(nameIndex);
        }
        return String.format("%6s", names.get(nameIndex));
    }

    public static void printLadder(Ladder ladder, int firstNameLength) {
        println(parseLadder(ladder, firstNameLength));
    }

    private static String parseLadder(Ladder ladder, int firstNameLength) {
        return ladder.getLines().stream()
                .map(OutputView::parseLine)
                .map(lineDisplay -> lineDisplay.substring(PER_NAME_SPACE - firstNameLength))
                .collect(Collectors.joining("\n"));
    }

    private static String parseLine(Line line) {
        return line.getBars().stream()
                .map(OutputView::parseBar)
                .collect(Collectors.joining("|", "", "|"));
    }

    private static String parseBar(Bar bar) {
        return parseBarMatcher(bar).getBarDisplay();
    }

    private static BarMatcher parseBarMatcher(Bar bar) {
        return BarMatcher.valueOfBarMatcher(bar);
    }

    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        println(illegalArgumentException.getMessage());
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
