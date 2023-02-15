package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Names;
import ladder.domain.RandomGenerator;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names names;
    private Lines lines;

    public void run() {
        names = Repeater.repeatIfError(this::inputNames, ResultView::printErrorMessage);
        lines = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        lines.generateLegsOfLines(new RandomGenerator());
        ResultView.printResult(names.toDto(), lines.toDto());
    }

    private Names inputNames() {
        return new Names(InputView.inputPlayerNames());
    }

    private Lines inputLines() {
        return new Lines(InputView.inputLadderHeight(), names.getCount());
    }
}
