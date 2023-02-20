package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private static final int DIFFERENCE_PLAYERS_AND_BARS = 1;

    public void play() {
        Players players = new Players(InputView.readNames());
        Ladder ladder = Ladder.generate(InputView.readCountOfLines(), getCountOfBars(players),
                new RandomBooleanGenerator());
        OutputView.printPlayers(players.getNameValues());
        OutputView.printLadder(ladder.getLines());
    }

    private int getCountOfBars(Players players) {
        return players.getSize() - DIFFERENCE_PLAYERS_AND_BARS;
    }
}
