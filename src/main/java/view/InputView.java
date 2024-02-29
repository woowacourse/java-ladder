package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public String readToken() {
        return scanner.nextLine();
    }

    public List<String> readTokens() {
        String names = scanner.nextLine();
        String[] splitTokens = names.split(SPLIT_DELIMITER);

        return Arrays.stream(splitTokens)
                .toList();
    }

    public int readLadderHeight() {
        String input = scanner.nextLine();
        return convertToInteger(input);
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수로 입력해야 합니다.");
        }
    }
}