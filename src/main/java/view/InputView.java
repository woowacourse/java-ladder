package view;

import exception.ErrorCode;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String requestNames() {
        System.out.println(REQUEST_NAME);
        return scanner.nextLine();
    }

    public int requestLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        return validateOnlyNumber(scanner.nextLine());
    }

    private int validateOnlyNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_NOT_INTEGER.getMessage());
        }
    }
}
