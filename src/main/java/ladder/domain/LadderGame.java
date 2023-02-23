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

    /**
     * 혹은 ladder에서는 map형식의 결과값만 반환하고
     * 컨트롤러에서 명령이 all이면 전부 주고, 이름이면 그중에 하나만
     * getPlayerBy쓰지말고, map을 넣어서 players에서 저장하도록하기
     */

    public Map<String, String> showResult() {
        Map<String, String> result = new HashMap<>();

        players.inputStatusOfPlayers(result);

        return result;
    }
}
