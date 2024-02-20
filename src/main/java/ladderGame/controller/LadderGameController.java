package ladderGame.controller;

import ladderGame.model.Ladder;
import ladderGame.model.Players;
import ladderGame.view.InputView;

public class LadderGameController {
    private InputView inputView;

    public LadderGameController() {
        this.inputView = new InputView();
    }

    public void run() {
        Players players = new Players(inputView.inputPlayerNames());
        Ladder ladder = new Ladder(inputView.inputMaxLadderHeight(), players.getPlayerSize());
    }
}
