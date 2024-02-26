package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> readPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(SCANNER.nextLine().split(","))
                .toList();
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static List<String> readPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return Arrays.stream(SCANNER.nextLine().split(","))
                .toList();
    }

    public static String readResultTarget() {
        System.out.println("결과를 보고 싶은 사람은?");

        return SCANNER.nextLine();
    }
}
