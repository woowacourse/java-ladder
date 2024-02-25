package laddergame.view;

import laddergame.domain.*;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String SPACE = "\t";

    public void writePlayersName(final Players players) {
        System.out.println(String.join(SPACE, players.getPlayers().stream()
                .map(Player::getName)
                .toList()));
    }

    public void writeLadder(final Ladder ladder) {
        ladder.getLines().forEach(this::writeLine);
    }

    private void writeLine(final Line line) {
        String formatted = line.getZones().stream()
                .map(Zone::getSymbol)
                .collect(Collectors.joining(LADDER_SEPARATOR, SPACE + LADDER_SEPARATOR, LADDER_SEPARATOR));

        System.out.println(formatted);
    }

    public void writeResultTitle() {
        System.out.println(LINE_SEPARATOR + "실행결과" + LINE_SEPARATOR);
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
