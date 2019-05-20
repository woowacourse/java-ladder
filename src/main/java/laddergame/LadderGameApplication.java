package laddergame;

import laddergame.controller.GamePreparer;
import laddergame.controller.rule.RandomCreateRule;
import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameResult;
import laddergame.domain.Tags;
import laddergame.util.InputView;
import laddergame.util.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Tags members = GamePreparer.makeMembers();
        LadderGame ladderGame = new LadderGame(members, GamePreparer.makePrizes(members.size()),
                GamePreparer.makeHeight(), new RandomCreateRule());

        OutputView.outputLadderGame(ladderGame);
        LadderGameResult ladderGameResult = ladderGame.startGame();

        OutputView.outputLadderGameResult(InputView.inputWantResult(), ladderGameResult);
    }
}
