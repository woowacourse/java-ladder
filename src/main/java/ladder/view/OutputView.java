package ladder.view;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String EXECUTION_RESULT = "사다리 결과" + System.lineSeparator();
    private static final String PEOPLE_NAMES_DELIMITER = " ";
    private static final String PRIZES_DELIMITER = " ";
    private static final String LINE_PILLAR = "|";
    private static final String LADDER_SCAFFOLD = "-";
    private static final String LADDER_BLANK = " ";

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResult(List<String> peopleNames, List<List<Boolean>> lines, List<String> prizeNames) {
        List<Integer> scaffoldSizes = measureScaffoldSizes(peopleNames, prizeNames);

        printResultTitle();
        printPeopleNames(peopleNames, scaffoldSizes);
        printLadderLines(lines, scaffoldSizes);
        printPrizes(prizeNames, scaffoldSizes);
    }

    private static void printResultTitle() {
        System.out.println(EXECUTION_RESULT);
    }

    private static void printPeopleNames(List<String> names, List<Integer> sizes) {
        StringJoiner joiner = new StringJoiner(PEOPLE_NAMES_DELIMITER);
        IntStream.range(0, names.size())
                .forEach(i -> joiner.add(createLeftPadding(names.get(i), sizes.get(i))));
        System.out.println(joiner);
    }

    private static void printPrizes(List<String> names, List<Integer> sizes) {
        StringJoiner joiner = new StringJoiner(PRIZES_DELIMITER);
        IntStream.range(0, names.size())
                .forEach(i -> joiner.add(createLeftPadding(names.get(i), sizes.get(i))));
        System.out.println(joiner);
    }

    private static void printLadderLines(List<List<Boolean>> lines, List<Integer> sizes) {
        lines.forEach(line -> printLine(line, sizes));
    }

    private static void printLine(List<Boolean> line, List<Integer> sizes) {
        String linePrefix = String.format("%" + sizes.get(0) + "s", LINE_PILLAR);
        StringJoiner joiner = new StringJoiner(LINE_PILLAR, linePrefix, LINE_PILLAR);
        IntStream.range(0, line.size())
                .forEach(i -> joiner.add(selectScaffold(line.get(i)).repeat(sizes.get(i + 1))));
        System.out.println(joiner);
    }

    private static String createLeftPadding(String value, int length) {
        return String.format("%" + length + "s", value);
    }

    private static List<Integer> measureScaffoldSizes(List<String> names, List<String> prizes) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> Math.max(names.get(i).length(), prizes.get(i).length()))
                .toList();
    }

    private static String selectScaffold(Boolean exist) {
        if (exist) {
            return LADDER_SCAFFOLD;
        }
        return LADDER_BLANK;
    }
}
