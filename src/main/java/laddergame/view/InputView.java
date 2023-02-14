package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";

    public static List<String> inputPlayerNames() {
        String playerNames = scanner.nextLine();
        validateBlankInput(playerNames);
        return Arrays.asList(playerNames.split(SPLIT_DELIMITER));
    }

    private static void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }
}
