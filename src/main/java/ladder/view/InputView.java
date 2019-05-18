package ladder.view;

import ladder.domain.UserOutput;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println(UserOutput.DEMAND_PLAYER_NAMES.getOutputMessage());
        return scanner.nextLine();
    }

    public static String inputHeight() {
        System.out.println(UserOutput.DEMAND_LADDER_HEIGHT.getOutputMessage());
        return scanner.nextLine();
    }

    public static String inputResults() {
        System.out.println(UserOutput.DEMAND_GAME_RESULTS.getOutputMessage());
        return scanner.nextLine();
    }

    public static String inputNameForResult() {
        System.out.println(UserOutput.DEMAND_PLAYER_NAME_FOR_RESULT.getOutputMessage());
        return scanner.nextLine();
    }
}
