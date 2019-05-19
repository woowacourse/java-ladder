package laddergame;

import laddergame.domain.*;
import laddergame.domain.rule.RandomCreateRule;
import laddergame.util.InputView;
import laddergame.util.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        try {
            Players players = new Players(InputView.inputPlayerNames());
            Rewards rewards = new Rewards(InputView.inputRewardNames());
            LadderGame ladderGame = new LadderGame(players.size(),
                    InputView.inputHeight(),
                    new RandomCreateRule());

            OutputView.outputLadderGame(ladderGame, players, rewards);

            LadderGameResult ladderGameResult = ladderGame.startGame(players, rewards);

            OutputView.outputLadderGameResult(InputView.inputWantResult(), ladderGameResult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
