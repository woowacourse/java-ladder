package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String PLAYER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static void printPlayerNameInputGuideMessage() {
        System.out.println(PLAYER_NAME_INPUT_GUIDE_MESSAGE);
    }

    public List<String> readPlayerNames() {
        printPlayerNameInputGuideMessage();

        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        return List.of(playerName.split(DELIMITER));
    }

    public String readLadderHeight() {
        printLadderHeightGuideMessage();
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private void printLadderHeightGuideMessage() {
        System.out.println(LADDER_HEIGHT_INPUT_GUIDE_MESSAGE);
    }

    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
}
