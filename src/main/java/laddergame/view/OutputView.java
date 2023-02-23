package laddergame.view;

import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Names;
import laddergame.domain.prize.Prizes;
import laddergame.domain.prize.Result;

import java.util.List;

import static java.util.stream.Collectors.joining;

public enum OutputView {
    BLANK(" "),
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-");

    private static final String RESULT_ALL_OUTPUT_MESSAGE = "%s : %s";
    private static final int HALF = 2;
    private final String ladderElement;

    OutputView(final String ladderElement) {
        this.ladderElement = ladderElement;
    }

    public static void printPlayerAll(final Names names) {
        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());

        final String allPlayerName = names.getNames().stream()
                .map(player -> makeNameFormat(names.findMaxNameLength(), player))
                .collect(joining(BLANK.ladderElement));

        System.out.println(allPlayerName);
    }

    public static void printLadder(final Names names, final Ladder ladder) {
        StringBuilder result = new StringBuilder();
        ladder.getLines().forEach(line -> result.append(makeLadderFormat(line.getConnections(), names)));
        System.out.print(result);
    }

    public static void printMessage(final String message) {
        System.out.println("[ERROR] " + message + System.lineSeparator());
    }

    private static String makeLadderFormat(final List<Connection> connections, final Names names) {
        final StringBuilder result = new StringBuilder();
        result.append(createStartBlank(names.getNames().get(0)));
        result.append(VERTICAL_LINE.ladderElement);
        connections.forEach(connection ->
                result.append(
                        makeLine(connection, names.findMaxNameLength())
                ));
        result.append(System.lineSeparator());
        return result.toString();
    }

    private static String makeLine(final Connection connection, final int maxNameLength) {
        if (connection.isConnected()) {
            return HORIZONTAL_LINE.ladderElement.repeat(maxNameLength) + VERTICAL_LINE.ladderElement;
        }

        return BLANK.ladderElement.repeat(maxNameLength) + VERTICAL_LINE.ladderElement;
    }

    public static void printResult(final List<Result> results) {
        System.out.println(System.lineSeparator() + "실행 결과");

        if (results.size() == 1) {
            System.out.println(results.get(0).getPrize());
            return;
        }

        results.forEach(OutputView::printResultAll);
    }

    private static void printResultAll(final Result result) {
        System.out.println(String.format(RESULT_ALL_OUTPUT_MESSAGE, result.getName(), result.getPrize()));
    }

    public static void printPrizesAll(final Prizes prizes, final int maxNameLength) {
        final StringBuilder result = new StringBuilder();
        result.append(createStartBlank(prizes.getPrize(0).getPrize()));
        final String prizeFormat = prizes.getPrizes().stream()
                .map(prize -> makeNameFormat(maxNameLength, prize.getPrize()))
                .collect(joining(BLANK.ladderElement));
        result.append(prizeFormat);

        System.out.println(result);
    }

    private static String createStartBlank(final String startName) {
        final int repeatTimes = Math.round(startName.length() / HALF);
        return BLANK.ladderElement.repeat(repeatTimes);
    }

    private static String makeNameFormat(final int maxNameLength, final String name) {
        int count = maxNameLength - name.length();
        final String repeat = BLANK.ladderElement.repeat(count);

        return String.format("%s%s", name, repeat);
    }
}
