package view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String requestNames() {
        System.out.println(REQUEST_NAME);
        return scanner.nextLine();
    }

    public String requestHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        return scanner.nextLine();
    }

    public String requestResult() {
        System.out.println(REQUEST_LADDER_RESULT);
        return scanner.nextLine();
    }
}
