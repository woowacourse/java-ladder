package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        String input = input();

        validateSeparatorShape(input);
        return getSeparated(input);
    }

    public static int getHeight() {
        int input;

        try {
            input = Integer.parseInt(input());
            validatePositiveInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
        return input;
    }

    private static void validatePositiveInteger(final int input) {
        if (input < 1) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
    }

    private static List<String> getSeparated(final String input) {
        return List.of(removeSpace(input).split(SEPARATOR));
    }

    private static String removeSpace(final String input) {
        return input.replace(SPACE, BLANK);
    }

    private static String input() {
        return scanner.nextLine();
    }

    private static void validateSeparatorShape(final String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATOR + "로 이름으 구분해주세요");
        }
    }
}
