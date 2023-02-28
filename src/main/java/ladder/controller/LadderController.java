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

    public void run() {
        LadderGame ladderGame = generateLadderGame();

        ResultView.printResult(ladderGame.getPlayers().getNames(), ladderGame.getLadder().getRows(),
            ladderGame.getRewards().getNames());
        repeatUntilQuit(ladderGame, ladderGame.getPlayers());
    }

    private LadderGame generateLadderGame() {
        Names playerNames = Repeater.repeatIfError(this::inputPlayerNames,
            ResultView::printErrorMessage);
        int playerCount = playerNames.findNamesCount();
        Names rewardNames = Repeater.repeatIfError(() -> inputRewardNames(playerCount),
            ResultView::printErrorMessage);
        Ladder ladder = Repeater.repeatIfError(() -> inputRows(playerCount),
            ResultView::printErrorMessage);
        return new LadderGame(playerNames, ladder, rewardNames);
    }

    private Names inputPlayerNames() {
        return new Names(InputView.inputPlayerNames());
    }

    private Names inputRewardNames(int count) {
        return new Names(InputView.inputRewardNames(), count);
    }

    private Ladder inputRows(int count) {
        int intervalCount = count - 1;
        return new Ladder(InputView.inputLadderHeight(), intervalCount, new RandomStepGenerator());
    }

    private void repeatUntilQuit(LadderGame ladderGame, Names playerNames) {
        String cmd = InputView.inputCommand();
        if (Command.QUIT.isEqual(cmd)) {
            ResultView.printQuitMessage();
            return;
        }
        tryNotQuitCase(cmd, ladderGame, playerNames);
        repeatUntilQuit(ladderGame, playerNames);
    }

    private void tryNotQuitCase(String cmd, LadderGame ladderGame, Names playerNames) {
        if (Command.ALL.isEqual(cmd)) {
            ResultView.printAllResult(ladderGame.getLadderResult());
            return;
        }
        try {
            ResultView.printResult(ladderGame.findRewardByName(playerNames.findName(cmd)));
        } catch (Exception e) {
            ResultView.printErrorMessage(e);
        }

    }

}
