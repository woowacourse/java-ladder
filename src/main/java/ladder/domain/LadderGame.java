package ladder.domain;

import ladder.view.InputView;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame() {
        this.players = new Players(InputView.readNames());
        this.ladder = new Ladder(InputView.readCountOfLines(), getCountOfBars());
    }

    private int getCountOfBars() {
        return this.players.getSize() - 1;
    }

    public void play() {
        OutputView.printPlayers(players.getPlayers());
        OutputView.printLadder(ladder.getLines());
    }
}
