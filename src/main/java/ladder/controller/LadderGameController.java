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
        this.ladderGame = new LadderGame(readNames(), readLadderHeight());
    }

    private List<String> readNames() {
        OutputView.printPlayerNamesReadMessage();
        try {
            return InputView.readNames();
        } catch (IllegalArgumentException e) {
            return readNames();
        }
    }

    private int readLadderHeight() {
        OutputView.printMaxLadderHeightReadMessage();
        try {
            return InputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            return readLadderHeight();
        }
    }

    private void printGameResult() {
        ResultView.printExecutionMessage();
        ResultView.printPlayerNames(ladderGame.getNames());
        ResultView.printLadder(ladderGame.getLines());
    }
}
