package laddergame.domain;

public class LadderGame {
    private Players players;
    private Rewards rewards;
    private Ladder ladder;

    public LadderGame(Players players, Rewards rewards, Ladder ladder) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public void start() {
        players.rideLadder(ladder.getLines());
        players.matchRewards(rewards.getRewards());
    }
}
