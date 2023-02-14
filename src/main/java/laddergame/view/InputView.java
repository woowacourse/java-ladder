package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";

    public static List<String> inputPlayerNames() {
        String playerNames = scanner.nextLine();
        return Arrays.asList(playerNames.split(SPLIT_DELIMITER));
    }
}
