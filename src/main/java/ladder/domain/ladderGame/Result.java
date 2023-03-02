package ladder.domain.ladderGame;

import ladder.constant.Command;
import ladder.domain.player.PlayerName;
import ladder.domain.reward.RewardName;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private final Map<PlayerName, RewardName> result;

    public Result(Map<PlayerName, RewardName> result) {
        //null체크 하기
        this.result = result;
    }

    public String findValidRequest(final String request) {
        if (!request.equals(Command.REQUEST_TO_GET_ALL_RESULT)
                && !result.containsKey(new PlayerName(request))) {
            throw new IllegalArgumentException("해당하는 플레이어의 이름이 없습니다.");
        }
        return request;
    }

    public Map<String, String> findResultByRequest(String request) {

        if (request.equals(Command.REQUEST_TO_GET_ALL_RESULT)) {
            return findResultOfAllPlayers();
        }
        return findResultOfOnePlayer(request);
    }

    private Map<String, String> findResultOfAllPlayers() {
        Map<String, String> resultOfAllPlayers = new LinkedHashMap<>();

        result.forEach((playerName, rewardName) ->
                resultOfAllPlayers.put(playerName.getName(), rewardName.getName()));

        return resultOfAllPlayers;
    }

    private Map<String, String> findResultOfOnePlayer(String onePlayer) {
        Map<String, String> resultOfOnePlayer = new LinkedHashMap<>();
        PlayerName playerName = new PlayerName(onePlayer);

        resultOfOnePlayer.put(onePlayer, result.get(playerName).getName());
        return resultOfOnePlayer;
    }
}
