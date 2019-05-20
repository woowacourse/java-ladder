package ladder;

import ladder.domain.LadderResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApp {

    public static void main(String[] args) {
        String names = InputView.playerNames();
        String rewards = InputView.rewards(names.split(",").length);
        int depth = InputView.ladderDepth();

        LadderResult ladderResult = new LadderResult(names, rewards, depth);

        OutputView.outputLadder(names, ladderResult.getLadderShape(), rewards);
        OutputView.outputLadderReward(InputView.wantName(ladderResult));
    }
}
