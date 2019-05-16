package ladder;

import ladder.domain.Ladder;
import ladder.util.Rule;
import ladder.util.Util;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;

public class LadderApp {

    public static void main(String[] args) {
        String names = inputPlayerNames(InputView.inputPlayerNames());
        String rewards = InputRewards(InputView.inputRewards(), names.split(",").length);
        int depth = inputLadderDepth(InputView.inputLadderDepth());
        Ladder ladder = new Ladder(names, rewards, depth);
        ladder.playRadder();
        OutputView.outputLadder(ladder.getResultLadderNames(), ladder.getResultLadderLines(), ladder.getResultLadderRewards());
        OutputView.outputLadderReward(inputWantName(ladder.getResultLadderRewards(InputView.inputWantName()),ladder));
    }

    private static String inputWantName(String inputWantName, Ladder ladder) {
        try {
            return Rule.ruleInputWantName(inputWantName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputWantName(ladder.getResultLadderRewards(InputView.inputWantName()), ladder);
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
