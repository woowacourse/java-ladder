package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String PEOPLE_NAMES_DELIMITER = " ";
    private static final String PRIZES_DELIMITER = " ";
    private static final String EXECUTION_RESULT_ONCE_DELIMITER = ", ";
    private static final String EXECUTION_RESULT_ALL_DELIMITER = " : ";
    private static final String LINE_PILLAR = "|";
    private static final String LADDER_SCAFFOLD = "-";
    private static final String LADDER_BLANK = " ";

    private ResultView() {
    }

    public static void printResult(List<String> peopleNames, List<List<Boolean>> lines, List<String> prizeNames) {
        List<Integer> scaffoldSizes = measureScaffoldSizes(peopleNames, prizeNames);

        printResultTitle();
        printPeopleNames(peopleNames, scaffoldSizes);
        printLadderLines(lines, scaffoldSizes);
        printPrizes(prizeNames, scaffoldSizes);
        System.out.println();
    }

    private static void printResultTitle() {
        System.out.println(LADDER_RESULT);
        System.out.println();
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

    public static void printExecutionResultOnce(String prize) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(String.join(EXECUTION_RESULT_ONCE_DELIMITER, prize));
        System.out.println();
    }

    public static void printExecutionResultAll(Map<String, String> result) {
        System.out.println(EXECUTION_RESULT);
        result.forEach((name, prize) ->
                System.out.println(name + EXECUTION_RESULT_ALL_DELIMITER + prize));
        System.out.println();
    }

}
