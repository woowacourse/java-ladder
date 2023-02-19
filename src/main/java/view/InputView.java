package view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String enterParticipantsName() {
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

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

}
