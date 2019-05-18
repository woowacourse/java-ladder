package laddergame;

import laddergame.domain.*;
import laddergame.domain.rule.RandomCreateRule;
import laddergame.util.InputView;
import laddergame.util.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        try {
            LadderGame ladderGame = new LadderGame(
                    InputView.inputPlayerNames(),
                    InputView.inputRewardNames(),
                    InputView.inputHeight(),
                    new RandomCreateRule());

            OutputView.outputLadderGame(ladderGame);

            LadderGameResult ladderGameResult = ladderGame.startGame();

            OutputView.outputLadderGameResult(InputView.inputWantResult(), ladderGameResult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
