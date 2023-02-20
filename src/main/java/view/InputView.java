package view;

import domain.Height;
import java.util.Scanner;

public class InputView {

    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String NON_INTEGER_ERROR_MESSAGE = "높이는 정수만 입력 가능합니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String requestPlayerNames() {
        return requestUserInput(PLAYER_NAME_INPUT_MESSAGE);
    }

    public Height requestLadderHeight() {
        String heightInput = requestUserInput(LADDER_HEIGHT_INPUT_MESSAGE);
        try {
            return new Height(Integer.parseInt(heightInput));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    private String requestUserInput(String requestMessage) {
        System.out.println(requestMessage);
        String playerNames = SCANNER.nextLine();
        System.out.print(System.lineSeparator());
        return playerNames;
    }

    public String getPlayerNameDelimiter() {
        return PLAYER_NAME_DELIMITER;
    }
}
