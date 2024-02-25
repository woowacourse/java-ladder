package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Players;
import ladderGame.model.Results;
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
        Results results = new Results(inputView.inputResults(), players.getPlayerSize());
        Ladder ladder = new Ladder(inputView.inputMaxLadderHeight(), players.getPlayerSize());

        resultView.printLadder(players.getPlayers(), ladder.getLines());
    }
}
