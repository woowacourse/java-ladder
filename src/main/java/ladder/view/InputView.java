package ladder.view;

import ladder.domain.Floor;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNamesMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static Floor inputFloorsMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요");
        return new Floor(scanner.nextLine());
    }

    public static String inputResultNamesMessage() {
        System.out.println("실행결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputSelectResultMessage() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
