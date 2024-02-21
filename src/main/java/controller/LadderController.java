package controller;

import domain.Ladder;
import domain.Players;
import view.InputView;
import view.OutputView;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        Players players = new Players(InputView.readPlayerNames());
        Ladder ladder = new Ladder(InputView.readLadderHeight());
        ladder.makeLines(getWidth(players));
        OutputView.printResult(players, ladder);
    }

    private int getWidth(Players players){
        return players.getPlayers().size()-1;
    }
}
