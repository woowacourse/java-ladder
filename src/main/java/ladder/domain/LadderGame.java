package ladder.domain;

import ladder.view.InputView;
import ladder.view.OutputView;

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
        OutputView.printPlayers(players.getNameValues());
        OutputView.printLadder(ladder.getLines());
    }
}
