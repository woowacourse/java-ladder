package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Players;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        Players players = new Players(inputView.inputPlayerNames());
        Ladder ladder = new Ladder(inputView.inputMaxLadderHeight(), players.getPlayerSize());

        resultView.printLadder(players.getPlayers(), ladder.getLines());
    }
}
