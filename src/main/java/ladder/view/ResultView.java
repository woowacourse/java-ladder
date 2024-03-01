package ladder.view;

import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.Map;
import java.util.StringJoiner;

import ladder.domain.game.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderRow;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public void printLadderGame(final LadderGame ladderGame) {
        System.out.println("\n실행 결과\n");
        printPlayers(ladderGame.players());
        printLadder(ladderGame.ladder());
        printRewards(ladderGame.rewards());
    }

    private void printPlayers(final Players players) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        players.players().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private void printLadder(final Ladder ladder) {
        ladder.getLadderRows().forEach(this::printLadderRow);
    }

    private void printRewards(final Rewards rewards) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        rewards.getRewards().forEach(reward -> stringJoiner.add(NAME_FORMAT.formatted(reward.value())));
        System.out.println(stringJoiner);
    }

    public void printReward(final Reward reward) {
        System.out.println("\n실행 결과");
        System.out.println(reward.value());
    }

    public void printAllResult(final Map<Player, Reward> allResult) {
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
