package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (결과는 쉼표(,)로 구분하세요");
        return scanner.nextLine().split(",");
    }

    public static String[] getDrawResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        return scanner.nextLine().split(",");
    }

    public static int getCountOfLines() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String getResult(){
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
