package ladder.domain.laddergame;

import ladder.constant.Command;
import ladder.domain.player.PlayerName;
import ladder.domain.reward.RewardName;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultOfLadderGame {

    private final Map<PlayerName, RewardName> result;

    public ResultOfLadderGame(final Map<PlayerName, RewardName> result) {
        this.result = result;
    }

    public String findValidRequest(final String request) {
        if (!request.equals(Command.REQUEST_TO_GET_ALL_RESULT)
                && !result.containsKey(new PlayerName(request))) {
            throw new IllegalArgumentException("해당하는 플레이어의 이름이 없습니다.");
        }
        return request;
    }

    public Map<String, String> findResultByRequest(final String request) {

        if (request.equals(Command.REQUEST_TO_GET_ALL_RESULT)) {
            return findResultOfAllPlayers();
        }
        return findResultOfOnePlayer(request);
    }

    private Map<String, String> findResultOfAllPlayers() {
        final Map<String, String> resultOfAllPlayers = new LinkedHashMap<>();

        result.forEach((playerName, rewardName) ->
                resultOfAllPlayers.put(playerName.getName(), rewardName.getName()));

        return resultOfAllPlayers;
    }

    private Map<String, String> findResultOfOnePlayer(final String onePlayer) {
        final Map<String, String> resultOfOnePlayer = new LinkedHashMap<>();
        final PlayerName playerName = new PlayerName(onePlayer);

        resultOfOnePlayer.put(onePlayer, result.get(playerName)
                .getName());
        return resultOfOnePlayer;
    }

}
