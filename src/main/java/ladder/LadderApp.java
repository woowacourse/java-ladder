package ladder;

import ladder.domain.LadderResult;
import ladder.util.Rule;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApp {

    public static void main(String[] args) {
        String names = inputPlayerNames(InputView.inputPlayerNames());
        String rewards = InputRewards(InputView.inputRewards(), names.split(",").length);
        int depth = inputLadderDepth(InputView.inputLadderDepth());

        LadderResult ladderResult = new LadderResult(names,rewards, depth);

        OutputView.outputLadder(names, ladderResult.getLadderShape(), rewards);
        OutputView.outputLadderReward(inputWantName(ladderResult.getResultOfName(InputView.inputWantName()),ladderResult));
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

    private static String InputRewards(String inputRewards, int count) {
        try {
            return Rule.ruleInputReward(inputRewards, count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return InputRewards(InputView.inputRewards(), count);
        }
    }

    private static String inputWantName(String inputWantName, LadderResult ladderResult) {
        try {
            return Rule.ruleInputWantName(inputWantName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputWantName(ladderResult.getResultOfName(InputView.inputWantName()), ladderResult);
        }
    }
}
