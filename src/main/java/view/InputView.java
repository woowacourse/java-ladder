package view;

import java.util.List;
import java.util.Scanner;
import validation.InputValidator;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String PLAYER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_GUIDE_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String PRIZE_NAME_INPUT_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String WANTED_RESULT_PLAYER_INPUT = "\n결과를 보고 싶은 사람은?";

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

    public List<String> readPrizeName() {
        System.out.println(PRIZE_NAME_INPUT_MESSAGE);

        String prizeName = scanner.nextLine();

        InputValidator.validatePrizeNameInput(prizeName);
        return List.of(prizeName.split(DELIMITER));
    }

    public String readWantedResultPlayer() {
        System.out.println(WANTED_RESULT_PLAYER_INPUT);

        String playerName = scanner.nextLine();

        InputValidator.validatePlayerNameInput(playerName);

        return playerName.trim();
    }

    private static void printPlayerNameInputGuideMessage() {
        System.out.println(PLAYER_NAME_INPUT_GUIDE_MESSAGE);
    }

    private void printLadderHeightGuideMessage() {
        System.out.println(LADDER_HEIGHT_INPUT_GUIDE_MESSAGE);
    }
}
