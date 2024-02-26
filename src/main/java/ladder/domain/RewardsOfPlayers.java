package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class RewardsOfPlayers {
    private final Map<String, String> rewardsOfPlayers;

    public RewardsOfPlayers(List<Player> resultPlayers, Results results) {
        rewardsOfPlayers = new HashMap<>();
        IntStream.range(0, resultPlayers.size())
                .forEach(location ->
                        rewardsOfPlayers.put(
                                getNameByLocation(resultPlayers, location),
                                results.getResultValue(location)
                        )
                );
    }

    public String getRewardByName(String name) {
        String reward = rewardsOfPlayers.get(name);
        if (reward == null) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        return reward;
    }

    public Map<String, String> getAllRewards() {
        return Map.copyOf(rewardsOfPlayers);
    }

    private static String getNameByLocation(List<Player> resultPlayers, int location) {
        return resultPlayers.stream()
                .filter(player -> player.hasSameLocation(location))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 사용자 결과 목록이 입력되었습니다."))
                .name();
    }
}
