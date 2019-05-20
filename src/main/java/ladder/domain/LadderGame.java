package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final DrawnLadder drawnLadder;
    private final List<Player> players;
    private final List<Reward> rewards;

    public LadderGame(DrawnLadder drawnLadder, List<Player> players, List<Reward> rewards) {
        this.drawnLadder = drawnLadder;
        this.players = players;
        this.rewards = rewards;
    }

    public List<Reward> play(List<Player> inputPlayers) {
        return players.stream().map(inputPlayer -> findReward(inputPlayer)).collect(Collectors.toList());
    }

    private Reward findReward(Player inputPlayer) {
        Position from = drawnLadder.createFirstColumnPosition().plus(players.indexOf(inputPlayer));
        Position to = Navigator.navigate(drawnLadder, from);

        return rewards.get(to.toInt());
    }
}
