package ladder.domain;

import ladder.constant.Command;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.List;
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
        trace();
    }

    private void trace() {
        IntStream.range(0, players.findNumberOfAllPlayers())
                .forEach(positionOfPlayer ->
                        players.rewardPlayer(positionOfPlayer, findRewardOfStartPositionInLadder(positionOfPlayer))
                );
    }

    private Reward findRewardOfStartPositionInLadder(int positionOfPlayer) {
        int resultPosition = ladder.findEndPositionFrom(positionOfPlayer);

        return rewards.findRewardBy(resultPosition);

    }

    public Map<String, String> findRewardsOfPlayersByRequest(final String request) {
        if (request.equals(Command.REQUEST_TO_GET_ALL_RESULT)) {
            return players.findRewardsOfPlayers();
        }
        return players.findRewardOfPlayerBy(request);
    }

    public String findValidRequest(String request) {
        if (!request.equals(Command.REQUEST_TO_GET_ALL_RESULT) && !findPlayerNames().contains(request)) {
            throw new IllegalArgumentException("해당하는 플레이어의 이름이 없습니다.");
        }

        return request;
    }

    public List<String> findPlayerNames() {
        return players.findNameOfAllPlayers();
    }

}
