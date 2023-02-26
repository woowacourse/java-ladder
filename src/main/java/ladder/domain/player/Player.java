package ladder.domain.player;

import ladder.domain.reward.Reward;

import java.util.Objects;

public class Player {

    private final PlayerName name;
    private Reward reward;

    public Player(PlayerName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public String getReward() {
        return reward.getName();
    }

    public void determineReward(final Reward reward) {
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
