package laddergame.view;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Point;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public OutputView() {

    }

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
        StringJoiner stringJoiner = new StringJoiner("|", "\t|", "|");
        for (Point point : line.getPoints().points()) {
            stringJoiner.add(PointSymbol.getSymbol(point));
        }
        System.out.println(stringJoiner);
    }

    public void writeResultTitle() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
