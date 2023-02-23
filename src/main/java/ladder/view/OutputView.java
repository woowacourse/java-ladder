package ladder.view;

import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int PER_NAME_SPACE = 6;

    private OutputView() {
    }

    public static void printGameResultsAll(HashMap<String, String> gameResults) {
        for (Map.Entry<String, String> entrySet : gameResults.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
    }

    public static void printGameResultsUnique(HashMap<String, String> gameResults, String name) {
        System.out.println("유니크출력");
        System.out.println(gameResults.get(name));
    }

    public static void printInputString(List<String> inputString) {
        println(parseDisplayInputStrings(inputString));
    }

    private static String parseDisplayInputStrings(List<String> inputString) {
        return IntStream.range(0, inputString.size())
                .mapToObj(nameIndex -> parseDisplayInputString(inputString, nameIndex))
                .collect(Collectors.joining());
    }

    private static String parseDisplayInputString(List<String> inputString, int stringIndex) {
        if (stringIndex == 0) {
            return inputString.get(stringIndex);
        }
        return String.format("%6s", inputString.get(stringIndex));
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
        return bar.getBarDisplay();
    }

    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        println(illegalArgumentException.getMessage());
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
