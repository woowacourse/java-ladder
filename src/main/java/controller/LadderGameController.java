package controller;

import domain.ladderGame.GameInit;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        InitLadderGame initLadderGame = new InitLadderGame(inputView);

        GameInit gameInit = initLadderGame.getGameInit();
        showInitResult(gameInit);
    }

    private void showInitResult(GameInit gameInit) {
        outputView.showInitResult(gameInit);
    }

}
