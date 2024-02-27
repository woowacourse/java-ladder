package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String rawNames = scanner.nextLine().trim();
        return List.of(rawNames.split(","));
    }

    public static List<String> readMatchingItems() {
        System.out.println("\n실행 결과를 입력하세요. (결과 쉼표(,)로 구분하세요)");
        final String rawNames = scanner.nextLine().trim();
        return List.of(rawNames.split(","));
    }

    public static int readHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("높이는 숫자여야 합니다.");
        }
    }
}
