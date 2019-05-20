package ladder;

import ladder.domain.LadderResult;
import ladder.util.Util;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApp {

    public static void main(String[] args) {
        String names = InputView.playerNames();
        String rewards = InputView.rewards();
        int depth = InputView.ladderDepth();

        LadderResult ladderResult = new LadderResult(names, rewards, depth);

        OutputView.outputLadder(Util.formatAlignRight(names), ladderResult.getLadderShape(), Util.formatAlignRight(rewards));
        OutputView.outputLadderReward(InputView.wantName(ladderResult));
    }
}
