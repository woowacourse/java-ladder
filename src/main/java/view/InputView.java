package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String input() {
        return scanner.nextLine();
    }

    public static List<String> inputNames() {
        String initialInput = input();
        return Arrays.stream(initialInput.split(","))
                     .map(String::trim)
                     .toList();
    }
}
