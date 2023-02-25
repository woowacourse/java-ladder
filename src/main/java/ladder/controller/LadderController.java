package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;

    private final Players players;
    private final Lines lines;

    public LadderController() {
        this.players = new Players(InputView.readNames());
        this.lines = new Lines(InputView.readCountOfLines(), getCountOfBars());
    }

    private int getCountOfBars() {
        return this.players.getSize() - DIFFERENCE_PLAYERS_AND_BARS;
    }

    public void play() {
        OutputView.announceExecution();
        OutputView.printPlayers(players.getNameValues());
        OutputView.printLadder(lines.getLines());
    }
}
