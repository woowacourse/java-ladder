package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    public static final String PLAYER_NAME_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름으로 공백 혹은 빈 칸을 입력할 수 없습니다";

    public List<String> readPlayerName() {
        printPlayerNameInputGuideMessage();

        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        validatePlayerNameInput(playerName);
       return List.of(playerName.split(DELIMITER));
    }

    private static void printPlayerNameInputGuideMessage() {
        System.out.println(PLAYER_NAME_INPUT_GUIDE_MESSAGE);
    }

    private void validatePlayerNameInput(String playerName){
        if(playerName.isBlank() || playerName.isEmpty()){
            throw new IllegalArgumentException(PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE);
        }
    }
}
