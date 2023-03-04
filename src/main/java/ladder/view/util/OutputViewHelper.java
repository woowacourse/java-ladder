package ladder.view.util;

import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputViewHelper {
    OutputViewHelper() {
    }

    // 사람, 결과 출력 메소드
    public static String parseDisplayInputStrings(List<String> inputString) {
        return IntStream.range(0, inputString.size())
                .mapToObj(nameIndex -> parseDisplayInputString(inputString, nameIndex))
                .collect(Collectors.joining());
    }

    private static String parseDisplayInputString(List<String> inputString, int stringIndex) {
        return String.format("%6s", inputString.get(stringIndex));
    }

    // 사다리 출력 메소드
    public static String parseLadder(Ladder ladder) {
        return ladder.getLines().stream()
                .map(OutputViewHelper::parseLine)
                .collect(Collectors.joining("\n"));
    }

    private static String parseLine(Line line) {
        return line.getBars().stream()
                .map(OutputViewHelper::parseBar)
                .collect(Collectors.joining("|"));
    }

    private static String parseBar(Bar bar) {
        return bar.getBarDisplay();
    }

    // 오류 출력 메소드
    public static void printExceptionMessage(IllegalArgumentException illegalArgumentException) {
        println(illegalArgumentException.getMessage());
    }

    private static void println(String message) {
        System.out.println(message);
    }

}
