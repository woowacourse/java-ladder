package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Names;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names names;
    private Lines lines;

    public void run() {
        names = new Names(InputView.inputPlayerNames());
        lines = new Lines(InputView.inputLadderHeight(), names.getCount());

        lines.generateLegsOfLines(new RandomGenerator());
        ResultView.printResult(names.toDto(), lines.toDto());
    }
}
