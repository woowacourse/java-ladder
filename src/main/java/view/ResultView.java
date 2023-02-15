package view;

import ladder.domain.Bar;
import ladder.domain.Line;
import ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BLANK_BETWEEN_NAMES = " ";
    private static final String BAR_SYMBOL = "-";
    private static final String EMPTY_BAR_SYMBOL = " ";
    private static final String LADDER_VERTICAL_SYMBOL = "|";
    private static final String OUTPUT_RESULT_MESSAGE = "실행결과";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printLadder(List<String> playerNames, int nameLength, List<Line> ladder) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println(convertPlayerNames(playerNames, nameLength));
        System.out.println(convertLadder(ladder, nameLength));
    }

    public static void printError(String errorMessage){
        System.out.println(errorMessage);
    }

    private static String convertPlayerNames(List<String> playerNames, int nameLength) {
        String pattern = "%" + nameLength + "s";

        return playerNames.stream()
                .map(name -> String.format(pattern, name))
                .collect(Collectors.joining(BLANK_BETWEEN_NAMES));
    }

    private static String convertLadder(List<Line> ladder, int nameLength) {
        return ladder.stream()
                .map(line -> convertLine(line, nameLength))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String convertLine(Line line, int nameLength) {
        return line.getLine().stream()
                .map(bar -> convertBar(bar, nameLength))
                .collect(Collectors.joining(LADDER_VERTICAL_SYMBOL, String.format("%5s", LADDER_VERTICAL_SYMBOL), LADDER_VERTICAL_SYMBOL));
    }

    private static String convertBar(Bar bar, int nameLength) {
        String barSymbol = BAR_SYMBOL.repeat(nameLength);
        String emptyBarSymbol = EMPTY_BAR_SYMBOL.repeat(nameLength);

        if (bar.getValue()) {
            return barSymbol;
        }
        return emptyBarSymbol;
    }
}
