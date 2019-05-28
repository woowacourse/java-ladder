package ladder.domain;

import java.util.*;

public class GameResult {
    private final Map<Player, Reward> matches;

    private GameResult(Map<Player, Reward> matches) {
        this.matches = matches;
    }

    public static GameResult of(List<Player> players, List<Reward> resultRewards) {
        if (players.size() != resultRewards.size()) {
            throw new IllegalArgumentException("플레이어수와 보상의 수가 다릅니다.");
        }

        Map<Player, Reward> matches = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            matches.put(players.get(i), resultRewards.get(i));
        }

        return new GameResult(matches);
    }

    public Reward getResultReward(Player player) {
        if (!matches.containsKey(player)) {
            throw new NoSuchElementException("존재하지 않는 플레이어 입니다.)");
        }
        return matches.get(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }
}
