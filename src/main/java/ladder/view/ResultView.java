package ladder.view;

import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.Map;
import java.util.StringJoiner;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.LadderResult;
import ladder.domain.ladder.LadderResults;
import ladder.domain.ladder.LadderRow;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public void printLadderGame(final LadderGame ladderGame) {
        System.out.println("\n실행 결과\n");
        printPlayers(ladderGame.players());
        printLadder(ladderGame.ladder());
        printResults(ladderGame.ladderResults());
    }

    private void printPlayers(final Players players) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        players.players().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private void printLadder(final Ladder ladder) {
        ladder.getLadderRows().forEach(this::printLadderRow);
    }

    private void printResults(final LadderResults results) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        results.getLadderResults().forEach(result -> stringJoiner.add(NAME_FORMAT.formatted(result.value())));
        System.out.println(stringJoiner);
    }

    public void printResult(final LadderResult result) {
        System.out.println("\n실행 결과");
        System.out.println(result.value());
    }

    public void printAllResult(final Map<Player, LadderResult> allResult) {
        System.out.println("\n실행 결과");
        allResult.forEach(((player, result) -> System.out.printf("%s : %s%n", player.name(), result.value())));
    }

    private void printLadderRow(final LadderRow ladderRow) {
        System.out.print("\t");
        ladderRow.getLadderDirections().forEach(this::printLine);
        System.out.println();
    }

    private void printLine(final LadderDirection ladderDirection) {
        if (ladderDirection == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
