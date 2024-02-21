package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Names names = createNames();
        int height = inputView.readHeight();
        Ladder ladder = new Ladder(height, names.getSize());

        outputView.printResult(names, ladder);
    }

    private Names createNames() {
        String names = inputView.readNames();
        try {
            return new Names(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createNames();
        }
    }
}
