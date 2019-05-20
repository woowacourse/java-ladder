package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(InputView.inputNames());
        Prizes prizes = new Prizes(InputView.inputPrize());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(players.getCount(), height);

        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        OutputView.printLadderGame(ladderGame);

        LadderGameResult ladderGameResult = ladderGame.start();
        OutputView.showGameResult(ladderGameResult);
    }
}
