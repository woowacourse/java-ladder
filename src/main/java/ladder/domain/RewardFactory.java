package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RewardFactory {
    public static List<Reward> createAll(List<String> names, List<Player> players) {
        List<Reward> rewards = names.stream().map(name -> new Reward(name)).collect(Collectors.toList());

        if (players.size() != rewards.size()) {
            throw new IllegalArgumentException(
                    String.format("player 수와 rewards 수가 다릅니다. #players: %d, #rewards: %d"
                            , players.size(), rewards.size()));
        }

        return rewards;
    }
}
