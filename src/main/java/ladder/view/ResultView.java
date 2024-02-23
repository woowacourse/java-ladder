package ladder.view;

import static ladder.domain.Direction.RIGHT;

import java.util.StringJoiner;
import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.LadderLevel;
import ladder.domain.Players;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public static void printResult(Players players, Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printPlayers(Players players) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        players.stream().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.stream().forEach(ResultView::printLadderLevel);
    }

    private static void printLadderLevel(LadderLevel ladderLevel) {
        System.out.print("\t");
        ladderLevel.stream().forEach(ResultView::printLine);
        System.out.println();
    }

    private static void printLine(Direction direction) {
        if (direction == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
