package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {

    private LadderGame ladderGame;

    public void start() {
        init();
        printGameResult();
    }

    private void init() {
        try {
            this.ladderGame = new LadderGame(readNames(), readLadderHeight());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            init();
        }
    }

    private List<String> readNames() {
        OutputView.printPlayerNamesReadMessage();
        try {
            return InputView.readNames();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readNames();
        }
    }

    private int readLadderHeight() {
        OutputView.printMaxLadderHeightReadMessage();
        try {
            return InputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readLadderHeight();
        }
    }

    private void printGameResult() {
        ResultView.printExecutionMessage();
        ResultView.printPlayerNames(ladderGame.getNames());
        ResultView.printLadder(ladderGame.getLines());
    }
}
