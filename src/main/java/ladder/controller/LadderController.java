package ladder.controller;

import ladder.domain.Names;
import ladder.domain.PlayerNames;
import ladder.domain.RandomStepGenerator;
import ladder.domain.RewardNames;
import ladder.domain.Rows;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names playerNames;
    private Names rewardNames;
    private Rows rows;

    public void run() {
        playerNames = Repeater.repeatIfError(this::inputPlayerNames, ResultView::printErrorMessage);
        rewardNames = Repeater.repeatIfError(this::inputRewardNames, ResultView::printErrorMessage);
        rows = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        rows.generateLegsOfLines(new RandomStepGenerator());
        ResultView.printResult(playerNames.toDto(), rows.toDto(), rewardNames.toDto());
    }

    private Names inputPlayerNames() {
        return new PlayerNames(InputView.inputPlayerNames());
    }

    private Names inputRewardNames() {
        return new RewardNames(InputView.inputRewardNames(), playerNames.getCount());
    }

    private Rows inputLines() {
        int intervalCount = playerNames.getCount() - 1;
        return new Rows(InputView.inputLadderHeight(), intervalCount);
    }
}
