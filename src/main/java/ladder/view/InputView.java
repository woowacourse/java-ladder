package ladder.view;

import ladder.util.Const;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println(Const.INPUT_NAMES);
        return SCANNER.nextLine();
    }

    public static int inputLadderDepth() {
        try {
            System.out.println(Const.INPUT_DEPTH);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println(Const.EX_LINE_COUNT);
            return inputLadderDepth();
        }
    }

    public static String inputRewards() {
        System.out.println(Const.INPUT_REWARDS);
        return SCANNER.nextLine();
    }

    public static String inputWantName() {
        System.out.println(Const.INPUT_WANT_NAME);
        return SCANNER.nextLine();
    }
}
