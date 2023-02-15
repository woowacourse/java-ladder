package ladder.controller;

import ladder.domain.Names;
import ladder.domain.RandomGenerator;
import ladder.domain.Rows;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names names;
    private Rows rows;

    public void run() {
        names = Repeater.repeatIfError(this::inputNames, ResultView::printErrorMessage);
        rows = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        rows.generateLegsOfLines(new RandomGenerator());
        ResultView.printResult(names.toDto(), rows.toDto());
    }

    private Names inputNames() {
        return new Names(InputView.inputPlayerNames());
    }

    private Rows inputLines() {
        return new Rows(InputView.inputLadderHeight(), names.getCount() - 1);
    }
}
