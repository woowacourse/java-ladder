package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readPlayerNames() {
        printInputMessage(INPUT_PLAYER_NAMES_MESSAGE);
        String playerNamesInput = readLine();
        return Arrays.stream(playerNamesInput.split(",", -1))
                .map(String::strip)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int readLadderHeight() {
        printInputMessage(INPUT_LADDER_HEIGHT_MESSAGE);
        String ladderHeight = readLine();
        validateNotInteger(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private static void printInputMessage(final String message) {
        System.out.println(message);
    }

    private static String readLine() {
        String inputValue = scanner.nextLine().strip();
        validateNotEmpty(inputValue);
        return inputValue;
    }

    private static void validateNotEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public static void validateNotInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("사다리 높이는 숫자만 입력할 수 있습니다.");
        }
    }

}
