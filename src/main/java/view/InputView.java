package view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_HEIGHT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String ENTER_RESULTS = System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ENTER_GET_RESULT = System.lineSeparator() + "결과를 보고 싶은 사람은?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterParticipantNames() {
        System.out.println(ENTER_PARTICIPANTS_NAME);
        return readLine();
    }

    private String readLine() {
        return scanner.nextLine();
    }

    public String enterHeight() {
        System.out.println(ENTER_HEIGHT);
        return readLine();
    }

    public String enterResults() {
        System.out.println(ENTER_RESULTS);
        return readLine();
    }

    public String enterGetResult() {
        System.out.println(ENTER_GET_RESULT);
        return readLine();
    }
}
