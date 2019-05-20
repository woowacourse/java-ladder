package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.Rule;
import ladder.util.Const;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String playerNames() {
        try {
            return Rule.ruleInputPlayerNames(inputPlayerNames());
        } catch (RuntimeException e) { //TODO RuntimeException
            System.out.println(e.getMessage());
            return playerNames();
        }
    }

    private static String inputPlayerNames() {
        System.out.println(Const.INPUT_NAMES);
        return SCANNER.nextLine();
    }

    public static String rewards(int size) {
        try {
            String rewards = inputRewards();
            return Rule.ruleInputReward(rewards, size);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return rewards(size);
        }
    }

    private static String inputRewards() {
        System.out.println(Const.INPUT_REWARDS);
        return SCANNER.nextLine();
    }

    public static int ladderDepth() {
        try {
            return Rule.ruleLadderDepthRange(inputLadderDepth());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ladderDepth();
        }
    }

    private static int inputLadderDepth() {
        try {
            System.out.println(Const.INPUT_DEPTH);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Const.EX_LINE_COUNT);
            return inputLadderDepth();
        }
    }

    public static String wantName(LadderResult ladderResult) {
        try {
            String resultOfName = ladderResult.getResultOfName(inputWantName());
            return Rule.ruleInputWantName(resultOfName);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return wantName(ladderResult);
        }
    }

    private static String inputWantName() {
        System.out.println(Const.INPUT_WANT_NAME);
        return SCANNER.nextLine();
    }
}
