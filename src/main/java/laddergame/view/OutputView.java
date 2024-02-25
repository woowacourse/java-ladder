package laddergame.view;

import java.util.StringJoiner;
import java.util.stream.IntStream;

import laddergame.domain.*;

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
        IntStream.range(0, ladder.getLines().size())
                .forEach(i -> writeLine(ladder.getLines().get(i)));
    }

    private void writeLine(final Line line) {
        StringJoiner stringJoiner = new StringJoiner(LADDER_SEPARATOR, SPACE + LADDER_SEPARATOR, LADDER_SEPARATOR);
        for (Zone zone : line.getZones()) {
            stringJoiner.add(zone.getSymbol());
        }
        System.out.println(stringJoiner);
    }

    public void writeResultTitle() {
        System.out.println(LINE_SEPARATOR + "실행결과" + LINE_SEPARATOR);
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
