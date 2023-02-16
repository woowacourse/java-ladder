package view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public String requestPlayerNames() {
        return requestUserInput(PLAYER_NAME_INPUT_MESSAGE);
    }

    public String requestLadderHeight() {
        return requestUserInput(LADDER_HEIGHT_INPUT_MESSAGE);
    }

    private String requestUserInput(String requestMessage) {
        System.out.println(requestMessage);
        String playerNames = SCANNER.nextLine();
        System.out.print(System.lineSeparator());
        return playerNames;
    }
}
