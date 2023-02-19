package view;

import java.util.List;
import java.util.Scanner;
import validation.InputValidator;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String PLAYER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerName() {
        printPlayerNameInputGuideMessage();

        String playerName = scanner.nextLine();

        InputValidator.validatePlayerNameInput(playerName);
        return List.of(playerName.split(DELIMITER));
    }

    public int readLadderHeight() {
        printLadderHeightGuideMessage();

        String ladderHeight = scanner.nextLine();

        InputValidator.validateLadderHeightInput(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private static void printPlayerNameInputGuideMessage() {
        System.out.println(PLAYER_NAME_INPUT_GUIDE_MESSAGE);
    }

    private void printLadderHeightGuideMessage() {
        System.out.println(LADDER_HEIGHT_INPUT_GUIDE_MESSAGE);
    }
}
