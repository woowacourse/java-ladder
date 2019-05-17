package laddergame.util;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_MESSAGE = "잘못된 입력입니다!";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMembers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println(ERROR_MESSAGE);
            return inputHeight();
        }
    }

    public static String inputWantResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}