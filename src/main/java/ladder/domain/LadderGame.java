package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Rewards rewards;

    public LadderGame(final Players players, final Ladder ladder, final Rewards rewards) {
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public void trace() {
        IntStream.range(0,players.findNumberOfPlayers())
                .forEach(positionOfPlayer ->
                    players.rewardPlayer(positionOfPlayer, findRewardOfStartPosition(positionOfPlayer))
                );
    }

    private Reward findRewardOfStartPosition(int positionOfPlayer) {
        int resultPosition = ladder.findEndPositionFrom(positionOfPlayer);

        return rewards.getRewardBy(resultPosition);

    }
}
