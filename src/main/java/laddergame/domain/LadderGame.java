package laddergame.domain;

import java.util.List;

public class LadderGame {
    private List<Player> players;
    private Rewards rewards;
    private Ladder ladder;

    public LadderGame(Players players, Rewards rewards, Ladder ladder) {
        this.players = players.getPlayers();
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public void start() {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            players.stream()
                    .forEach(player -> player.move(line.isStep(player.getPosition() - 1),
                            line.isStep(player.getPosition())));
        }
        players.stream().forEach(player -> player.matchReward(rewards.getRewards()));
    }
}
