package ladder.controller;

import ladder.domain.Command;
import ladder.domain.LadderGame;
import ladder.domain.Names;
import ladder.domain.RandomStepGenerator;
import ladder.domain.Ladder;
import ladder.util.Repeater;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private Names playerNames;
    private LadderGame ladderGame;

    public void run() {
        playerNames = Repeater.repeatIfError(this::inputPlayerNames, ResultView::printErrorMessage);
        Names rewardNames = Repeater.repeatIfError(this::inputRewardNames,
            ResultView::printErrorMessage);
        Ladder ladder = Repeater.repeatIfError(this::inputRows, ResultView::printErrorMessage);

        ladderGame = new LadderGame(playerNames, ladder, rewardNames);

        ResultView.printResult(playerNames.toDto(), ladder.toDto(), rewardNames.toDto());
        repeatUntilQuit();
    }

    private Names inputPlayerNames() {
        return new Names(InputView.inputPlayerNames());
    }

    private Names inputRewardNames() {
        return new Names(InputView.inputRewardNames(), playerNames.findNamesCount());
    }

    private Ladder inputRows() {
        int intervalCount = playerNames.findNamesCount() - 1;
        return new Ladder(InputView.inputLadderHeight(), intervalCount, new RandomStepGenerator());
    }

    private void repeatUntilQuit() {
        String cmd = InputView.inputCommand();
        if (Command.QUIT.isEqual(cmd)) {
            ResultView.printQuitMessage();
            return;
        }
        tryNotQuitCase(cmd);
        repeatUntilQuit();
    }

    private void tryNotQuitCase(String cmd) {
        if (Command.ALL.isEqual(cmd)) {
            ResultView.printAllResult(ladderGame.toDto());
            return;
        }
        try {
            ResultView.printResult(ladderGame.getReward(playerNames.findName(cmd)));
        } catch (Exception e) {
            ResultView.printErrorMessage(e);
        }

    }

}
