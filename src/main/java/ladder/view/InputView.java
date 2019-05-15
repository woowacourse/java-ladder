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
        System.out.println(Const.INPUT_DEPTH);
        return SCANNER.nextInt();
    }
}
