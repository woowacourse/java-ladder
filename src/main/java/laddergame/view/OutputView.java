package laddergame.view;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Player;
import laddergame.domain.Players;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String LADDER_SEPARATOR = "|";
    private static final String SPACE = "\t";

    public void writePlayersName(final Players players) {
        System.out.println(String.join("\t", players.getPlayers().stream()
                .map(Player::getName)
                .toList()));
    }

    public void writeLadder(final Ladder ladder) {
        IntStream.range(0, ladder.getLines().size())
                .forEach(i -> writeLine(ladder.getLines().get(i)));
    }

    private void writeLine(final Line line) {
        StringJoiner stringJoiner = new StringJoiner(LADDER_SEPARATOR, SPACE + LADDER_SEPARATOR, LADDER_SEPARATOR);
        for (Boolean point : line.getPoints()) {
            stringJoiner.add(BridgeSymbol.getSymbol(point));
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
