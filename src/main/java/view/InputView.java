package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String PLAYER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름으로 공백 혹은 빈 칸을 입력할 수 없습니다";
    public static final String LADDER_HEIGHT_ERROR_MESSAGE = "[ERROR] 사다리의 높이는 숫자를 입력해야합니다";

    private static void printPlayerNameInputGuideMessage() {
        System.out.println(PLAYER_NAME_INPUT_GUIDE_MESSAGE);
    }

    public List<String> readPlayerName() {
        printPlayerNameInputGuideMessage();

        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        validatePlayerNameInput(playerName);
        return List.of(playerName.split(DELIMITER));
    }

    private void validatePlayerNameInput(String playerName) {
        if (playerName.isBlank() || playerName.isEmpty()) {
            throw new IllegalArgumentException(PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE);
        }
    }

    public int readLadderHeight() {
        printLadderHeightGuideMessage();
        Scanner scanner = new Scanner(System.in);
        String ladderHeight = scanner.nextLine();

        validateLadderHeightIsNumber(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private static void validateLadderHeightIsNumber(String ladderHeight) {
        try {
            Integer.parseInt(ladderHeight);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }


    private void printLadderHeightGuideMessage() {
        System.out.println(LADDER_HEIGHT_INPUT_GUIDE_MESSAGE);
    }
}
