package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String DELIMITER = ",";
    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> readNames() {
        String rawNames = SCANNER.nextLine();
        InputViewValidator.validateReadPlayerNames(rawNames);
        List<String> names = List.of(rawNames.split(DELIMITER, -1));
        InputViewValidator.validateNamesCount(names.size());
        return names;
    }

    public static int readLadderHeight() {
        String rawHeight = SCANNER.nextLine();
        InputViewValidator.validateNumeric(rawHeight);
        return Integer.parseInt(rawHeight);
    }

    public static List<String> readResults() {
        String rawResult = SCANNER.nextLine();
        InputViewValidator.validateReadResults(rawResult);
        return List.of(rawResult.split(DELIMITER, -1));
    }
}
