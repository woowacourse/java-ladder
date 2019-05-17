package laddergame.util;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANT_RESULT = "결과를 보고 싶은 사람은?";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다!";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        return scanner.nextLine();
    }

    public static int inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT);
            return Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println(ERROR_MESSAGE);
            return inputHeight();
        }
    }

    public static String inputWantResult() {
        System.out.println(INPUT_WANT_RESULT);
        return scanner.nextLine();
    }
}