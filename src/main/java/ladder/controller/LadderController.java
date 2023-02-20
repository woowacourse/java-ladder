package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;

    private final Players players;
    private final Ladder ladder;

    public LadderController() {
        this.players = new Players(InputView.readNames());
        this.ladder = new Ladder(InputView.readCountOfLines(), getCountOfBars());
    }

    private int getCountOfBars() {
        return this.players.getSize() - DIFFERENCE_PLAYERS_AND_BARS;
    }

    public void play() {
        OutputView.announceExecution();
        OutputView.printPlayers(players.getNameValues());
        OutputView.printLadder(ladder.getLines());
    }
}
