package ladder.view;

import static ladder.domain.ladder.Direction.RIGHT;

import java.util.Map;
import java.util.StringJoiner;
import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLevel;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

public class OutputView {
    private static final String DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";
    private static final String RESULT_FORMAT = "%-5s";

    public static void printLadderResult(Players players, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printPlayers(players);
        printLadder(ladder);
        printResults(results);
    }

    private static void printPlayers(Players players) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        players.stream().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name().value())));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.stream().forEach(OutputView::printLadderLevel);
    }

    private static void printLadderLevel(LadderLevel ladderLevel) {
        System.out.print("\t");
        ladderLevel.getDirections().forEach(OutputView::printLine);
        System.out.println();
    }

    private static void printLine(Direction direction) {
        if (direction == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }

    private static void printResults(Results results) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        results.getResults().forEach(result -> stringJoiner.add(RESULT_FORMAT.formatted(result.value())));
        System.out.println(stringJoiner);
    }

    public static void printResult(Result result) {
        System.out.println("\n실행 결과");
        System.out.println(result.value());
    }

    public static void printAllResults(Map<Player, Result> rewardOfPlayers) {
        System.out.println("\n실행 결과");
        rewardOfPlayers.forEach((player, result) -> System.out.println(player.name().value() + " : " + result.value()));
    }

    public static void printQuitMessage() {
        System.out.println("\n종료");
    }
}
