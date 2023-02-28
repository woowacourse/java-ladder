package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String DELIMITER = ",";
    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> readNames() {
        String rawNames = SCANNER.nextLine();
        List<String> names = List.of(rawNames.split(DELIMITER));
        InputViewValidator.validateNamesCount(names.size());

        for (String playerName : names) {
            InputViewValidator.validateNameIsAll(playerName);
        }
        return names;
    }

    public static int readLadderHeight() {
        String rawHeight = SCANNER.nextLine();
        InputViewValidator.validateNumeric(rawHeight);
        return Integer.parseInt(rawHeight);
    }

    public static List<String> readResults() {
        String rawResults = SCANNER.nextLine();
        return List.of(rawResults.split(DELIMITER));
    }

    public static String readTargetPlayer() {
        return SCANNER.nextLine();
    }
}
