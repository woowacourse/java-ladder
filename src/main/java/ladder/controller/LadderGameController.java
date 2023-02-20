package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGameController {

    private LadderGame ladderGame;

    public void start() {
        init();
        printGameResult();
    }

    private void init() {
        try {
            List<String> names = readNames();
            List<String> results = readResults();
            int height = readLadderHeight();
            this.ladderGame = new LadderGame(names, height, results);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            init();
        }
    }

    private List<String> readNames() {
        OutputView.printPlayerNamesReadMessage();
        return readUserInput(InputView::readNames);
    }

    private int readLadderHeight() {
        OutputView.printMaxLadderHeightReadMessage();
        return readUserInput(InputView::readLadderHeight);
    }

    private List<String> readResults() {
        OutputView.printResultsReadMessage();
        return InputView.readResults();
    }

    private void printGameResult() {
        ResultView.printExecutionMessage();
        ResultView.printPlayerNames(ladderGame.getNames());
        ResultView.printLadder(ladderGame.getLines());
        ResultView.printResults(ladderGame.getResults());
    }

    public <T> T readUserInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readUserInput(supplier);
        }
    }
}
