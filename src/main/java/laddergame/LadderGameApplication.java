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
            Ladder ladder = new Ladder(players.size(), InputView.inputHeight(), new RandomCreateRule());

            LadderGameResult ladderGameResult = ladder.startGame(players, rewards);

            OutputView.outputLadderGame(ladder, players, rewards);
            OutputView.outputLadderGameResult(InputView.inputWantResult(), ladderGameResult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
