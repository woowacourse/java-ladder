package ladder.view;

import static ladder.domain.LadderDirection.RIGHT;

import java.util.StringJoiner;

import ladder.domain.Ladder;
import ladder.domain.LadderDirection;
import ladder.domain.LadderLevel;
import ladder.domain.LadderResults;
import ladder.domain.Players;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    private ResultView() {
    }

    public static void printLadder(Players players, Ladder ladder, LadderResults results) {
        System.out.println("\n실행 결과\n");
        printPlayers(players);
        printLadder(ladder);
        printResults(results);
    }

    private static void printPlayers(Players players) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        players.getPlayers().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadderLevels().forEach(ResultView::printLadderLevel);
    }

    private static void printResults(LadderResults results) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        results.getLadderResults().forEach(result -> stringJoiner.add(NAME_FORMAT.formatted(result.value())));
        System.out.println(stringJoiner);
    }

    private static void printLadderLevel(LadderLevel ladderLevel) {
        System.out.print("\t");
        ladderLevel.getLadderDirections().forEach(ResultView::printLine);
        System.out.println();
    }

    private static void printLine(LadderDirection ladderDirection) {
        if (ladderDirection == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
