package ladderGame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_SEPERATOR = ",";

    public static String[] readNames() {
        String input = scanner.nextLine();
        return input.split(NAME_SEPERATOR);
    }

    public static int readRows() {
        return scanner.nextInt();
    }
}
