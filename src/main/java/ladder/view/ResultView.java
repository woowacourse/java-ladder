package ladder.view;

import static ladder.domain.LadderDirection.RIGHT;

import java.util.Map;
import java.util.StringJoiner;

import ladder.domain.Ladder;
import ladder.domain.LadderDirection;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.LadderRow;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public void printLadder(Players players, Ladder ladder, LadderResults results) {
        System.out.println("\n실행 결과\n");
        printPlayers(players);
        printLadder(ladder);
        printResults(results);
    }

    public void printResult(LadderResult result) {
        System.out.println("\n실행 결과");
        System.out.println(result.value());
    }

    public void printAllResult(Map<Player, LadderResult> allResult) {
        System.out.println("\n실행 결과");
        allResult.forEach(((player, result) -> System.out.printf("%s : %s%n", player.name(), result.value())));
    }

    private void printPlayers(Players players) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        players.players().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadderLevels().forEach(this::printLadderLevel);
    }

    private void printResults(LadderResults results) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        results.getLadderResults().forEach(result -> stringJoiner.add(NAME_FORMAT.formatted(result.value())));
        System.out.println(stringJoiner);
    }

    private void printLadderLevel(LadderRow ladderRow) {
        System.out.print("\t");
        ladderRow.getLadderDirections().forEach(this::printLine);
        System.out.println();
    }

    private void printLine(LadderDirection ladderDirection) {
        if (ladderDirection == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
