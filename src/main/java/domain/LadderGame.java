package domain;

import domain.ladder.Ladder;

public class LadderGame {
    private final Ladder ladder;
    private final PlayerNames playerNames;
    private final ResultContents resultContents;

    public LadderGame(Ladder ladder, PlayerNames playerNames, ResultContents resultContents) {
        this.ladder = ladder;
        this.playerNames = playerNames;
        this.resultContents = resultContents;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public void buildBridges() {
        ladder.buildBridges();
    }
}
