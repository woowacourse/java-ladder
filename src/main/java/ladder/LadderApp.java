package ladder;

import ladder.domain.Ladder;
import ladder.util.Rule;
import ladder.util.Util;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApp {
    public static void main(String[] args) {
        String names = inputPlayerNames(InputView.inputPlayerNames());
        int depth = inputLadderDepth(InputView.inputLadderDepth());
        Ladder ladder = new Ladder(names, depth);
        OutputView.outputLadder(ladder.getResultLadderNames(), ladder.getResultLadderLines());
    }

    private static String inputPlayerNames(String names) {
        try {
            return Rule.ruleInputPlayerNames(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayerNames(InputView.inputPlayerNames());
        }
    }

    private static int inputLadderDepth(int depth) {
        try {
            return Rule.ruleLadderDepthRange(depth);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputLadderDepth(InputView.inputLadderDepth());
        }
    }
}
