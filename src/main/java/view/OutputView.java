package view;

import domain.GameResult;
import domain.GameResults;

import java.util.Comparator;
import java.util.List;

public class OutputView {

    private static final String RESULT_TITLE = "실행결과";
    private static final String POINT_SEPARATOR = "|";
    private static final String GENERATED_LADDER_TITLE = "사다리 결과";
    private static final String RESULT_DELIMITER = " : ";

    public static void printGeneratedLadder(
            final List<String> playerNames,
            final List<List<Boolean>> ladder,
            List<String> gameGameResultNames
    ) {
        printEmptyLine();
        printLine(GENERATED_LADDER_TITLE);
        printEmptyLine();
        int nameFormatSize = getPlayerNameSize(playerNames);
        printPlayerNames(playerNames, nameFormatSize);
        printLadder(ladder, nameFormatSize);
        printGameResultNames(gameGameResultNames, nameFormatSize);
    }

    private static void printGameResultNames(final List<String> gameResultNames, final int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        String nameFormat = String.format("%%%ds", nameFormatSize);
        gameResultNames.forEach((gameResultName) -> {
            stringBuilder.append(String.format(nameFormat, gameResultName));
            stringBuilder.append(" ");
        });
        printLine(stringBuilder.toString());
        printEmptyLine();
    }

    private static int getPlayerNameSize(final List<String> playerNames) {
        return playerNames.stream()
                .map(String::length)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private static void printPlayerNames(final List<String> playerNames, final int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        String nameFormat = String.format("%%%ds", nameFormatSize);
        playerNames.forEach((playerName) -> {
            stringBuilder.append(String.format(nameFormat, playerName));
            stringBuilder.append(" ");
        });
        printLine(stringBuilder.toString());
    }

    private static void printLadder(final List<List<Boolean>> ladder, final int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Boolean> line : ladder) {
            stringBuilder.append(getLineUi(line, nameFormatSize));
            printLine(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    private static String getLineUi(final List<Boolean> line, final int nameFormatSize) {
        StringBuilder stringBuilder = new StringBuilder();
        getFormattedPoint(nameFormatSize - 1, false, stringBuilder);
        line.forEach(point -> getFormattedPoint(nameFormatSize, point, stringBuilder));
        return stringBuilder.toString();
    }

    public static void printGameResultsOfAllPlayers(final GameResults gameResults) {
        printEmptyLine();
        printLine(RESULT_TITLE);
        for (GameResult gameResult : gameResults.getGameResults()) {
            printLine(gameResult.getPlayer().getName() + RESULT_DELIMITER + gameResult.getGameResultName());
        }
    }

    public static void printGameResultOfSinglePlayer(final GameResult gameResult) {
        printEmptyLine();
        printLine(RESULT_TITLE);
        printLine(gameResult.getGameResultName());
        printEmptyLine();
    }

    private static void getFormattedPoint(
            final int nameFormatSize,
            final Boolean point,
            final StringBuilder stringBuilder
    ) {
        stringBuilder.append(getPointUi(point, nameFormatSize));
        stringBuilder.append(POINT_SEPARATOR);
    }

    private static String getPointUi(final boolean point, final int nameFormatSize) {
        return String.valueOf(PointUi.getPointUi(point))
                .repeat(Math.max(0, nameFormatSize));
    }

    private static void printEmptyLine() {
        printLine("");
    }

    private static void printLine(final String value) {
        System.out.println(value);
    }

}
