package laddergame.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Point;
import laddergame.domain.Result;
import laddergame.domain.Results;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_SYMBOL = "|";
    private static final String POINT_SPACE = "\t";
    private static final String LADDER_RESULT_TITLE = System.lineSeparator() + "사다리 결과" + System.lineSeparator();
    private static final String RESULT_TITLE = System.lineSeparator() + "실행결과";
    private static final String PLAYER_RESULT_FORMAT = "%s : %s" + System.lineSeparator();

    public void writeLadderResult(final Players players, final Ladder ladder, final Results results) {
        writeLadderResultTitle();
        writePlayersName(players);
        writeLadder(ladder);
        writeResultNames(results);
    }

    private void writeLadderResultTitle() {
        System.out.println(LADDER_RESULT_TITLE);
    }

    private void writePlayersName(final Players players) {
        System.out.println(String.join(POINT_SPACE, players.getPlayers().stream()
                .map(Player::getName)
                .toList()));
    }

    private void writeLadder(final Ladder ladder) {
        IntStream.range(0, ladder.getLadderSize())
                .forEach(i -> writeLine(ladder.getLines().get(i)));
    }

    private void writeLine(final Line line) {
        StringJoiner stringJoiner = new StringJoiner(LADDER_SYMBOL, POINT_SPACE + LADDER_SYMBOL, LADDER_SYMBOL);
        for (Point point : line.getPoints().points()) {
            stringJoiner.add(PointSymbol.getSymbol(point));
        }
        System.out.println(stringJoiner);
    }

    private void writeResultNames(final Results results) {
        System.out.println(String.join(POINT_SPACE, results.getResults().stream()
                .map(Result::name)
                .toList()));
    }

    private void writeResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void writeDesiredResult(final Result result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result.name());
    }

    public void writeAllResults(final Map<Player, Result> playerResult) {
        writeResultTitle();
        for (Entry<Player, Result> entry : playerResult.entrySet()) {
            System.out.printf(PLAYER_RESULT_FORMAT, entry.getKey().getName(), entry.getValue().name());
        }
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
