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

    public static List<String> readLadderResult() {
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(SCANNER.nextLine().split(","))
                .toList();
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }

    public static String readMenu() {
        System.out.println("메뉴를 입력하세요. 조회/종료");
        return SCANNER.nextLine();
    }

    public static String readNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
