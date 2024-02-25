package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    private static String input() {
        return scanner.next();
    }

    public static List<String> inputNames(String message) {
        System.out.println(message);
        String initialInput = input();
        return Arrays.stream(initialInput.split(","))
                     .map(String::trim)
                     .toList();
    }

    public static String inputHeight() {
        System.out.println(UserMessage.HEIGHT_INPUT_PROMPT);
        return input();
    }
}
