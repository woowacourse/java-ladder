package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    final static String DELIMITER = ",";
    final static String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static List<String> inputPlayer() {
        System.out.println(PLAYER_INPUT_MESSAGE);

        String playerNames = scanner.nextLine();
        return splitInputByDelimiter(playerNames);
    }

    private static List<String> splitInputByDelimiter(String input) {
        return List.of(input.split(DELIMITER));
    }


}
