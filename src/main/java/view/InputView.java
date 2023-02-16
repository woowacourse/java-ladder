package view;

import domain.Height;
import domain.PlayerNames;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final int SPLIT_LIMIT_REMOVER = -1;

    public PlayerNames requestPlayerNames() {
        String playerNamesInput = requestUserInput(PLAYER_NAME_INPUT_MESSAGE);
        List<String> playerNames = Arrays.stream(playerNamesInput.split(PLAYER_NAME_DELIMITER, SPLIT_LIMIT_REMOVER))
                .map(String::trim)
                .collect(Collectors.toList());

        return PlayerNames.from(playerNames);
    }

    public Height requestLadderHeight() {
        String heightInput = requestUserInput(LADDER_HEIGHT_INPUT_MESSAGE);
        try {
            return new Height(Integer.parseInt(heightInput));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("높이는 정수만 입력 가능합니다.");
        }
    }

    private String requestUserInput(String requestMessage) {
        System.out.println(requestMessage);
        String playerNames = SCANNER.nextLine();
        System.out.print(System.lineSeparator());
        return playerNames;
    }

}
