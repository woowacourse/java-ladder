package ladder.view;

import java.util.Scanner;

public class InputConsoleView {
    public static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }

    public static String inputRewards() {
        System.out.println("실행 결과를 입력하세여. (결과를 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static String inputResultName() {
        System.out.println("결과를 보고 싶은 사람은? 종료를 원하시면 EXIT를 입력하세요");
        return new Scanner(System.in).nextLine();
    }
}
