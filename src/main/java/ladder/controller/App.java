package ladder.controller;

import ladder.model.Game;
import ladder.view.InputView;
import ladder.view.OutputView;

public class App {
    public static void main(String[] argc) {
        Game game = new Game(InputView.inputNames(), InputView.inputRewards(), InputView.inputHeight());
        OutputView.printGame(game.getNames(), game.getLadder(), game.getRewards(), game.getMaxWordLength());
        for(;;) {
            OutputView.printResult(game.getResultOf(InputView.inputCandidates()));
        }
    }
}