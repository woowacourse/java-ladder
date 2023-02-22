package ladder.controller;

import ladder.domain.Names;
import ladder.domain.PlayerNames;
import ladder.domain.RandomStepGenerator;
import ladder.domain.ResultNames;
import ladder.domain.Rows;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names playerNames;
    private Names resultNames;
    private Rows rows;

    public void run() {
        playerNames = Repeater.repeatIfError(this::inputPlayerNames, ResultView::printErrorMessage);
        resultNames = Repeater.repeatIfError(this::inputResultNames, ResultView::printErrorMessage);
        rows = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        rows.generateLegsOfLines(new RandomStepGenerator());
        ResultView.printResult(playerNames.toDto(), rows.toDto(), resultNames.toDto());
    }

    private Names inputPlayerNames() {
        return new PlayerNames(InputView.inputPlayerNames());
    }

    private Names inputResultNames() {
        return new ResultNames(InputView.inputResultNames(), playerNames.getCount());
    }

    private Rows inputLines() {
        int intervalCount = playerNames.getCount() - 1;
        return new Rows(InputView.inputLadderHeight(), intervalCount);
    }
}
