package ladder.controller;

import ladder.domain.Command;
import ladder.domain.LadderGame;
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
    private LadderGame ladderGame;

    public void run() {
        playerNames = Repeater.repeatIfError(this::inputPlayerNames, ResultView::printErrorMessage);
        rewardNames = Repeater.repeatIfError(this::inputRewardNames, ResultView::printErrorMessage);
        rows = Repeater.repeatIfError(this::inputLines, ResultView::printErrorMessage);
        rows.generateLegsOfLines(new RandomStepGenerator());
        ResultView.printResult(playerNames.toDto(), rows.toDto(), rewardNames.toDto());
        ladderGame = new LadderGame(playerNames, rows, rewardNames);
        ladderGame.makeResultMap();
        repeatQuestionAwnser();
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

    private void repeatQuestionAwnser() {
        String cmd = Repeater.repeatIfError(this::inputCommand, ResultView::printErrorMessage);
        if (Command.QUIT.isEqual(cmd)) {
            ResultView.printQuitMessage();
            return;
        }
        if (Command.ALL.isEqual(cmd)) {
            ResultView.printAllResult(ladderGame.toDto());
        }
        if (playerNames.findName(cmd) != null) {
            ResultView.printResult(ladderGame.getReward(playerNames.findName(cmd)));
        }
        repeatQuestionAwnser();
    }

    private String inputCommand() {
        String cmd = InputView.inputCommand();
        validateCommand(cmd);
        return cmd;
    }

    //입력값에 대한 유효성 검사를 하는 Domain 클래스를 만들어서 분리하는 게 더 좋을까요??
    private void validateCommand(String cmd) {
        if (playerNames.findName(cmd) == null && !Command.ALL.isEqual(cmd) && !Command.QUIT.isEqual(
            cmd)) {
            throw new IllegalArgumentException(String.format("%s라는 이름의 참여자는 없습니다.", cmd));
        }
    }
}
