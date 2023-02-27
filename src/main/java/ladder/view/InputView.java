package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String PLAYER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_GAME_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PLAYER_GAME_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputPlayer() {
        System.out.println(PLAYER_INPUT_MESSAGE);

        String playerNames = scanner.nextLine();
        return splitInputByDelimiter(playerNames);
    }

    private List<String> splitInputByDelimiter(String input) {
        return List.of(input.split(DELIMITER));
    }

    public int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);

        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public List<String> inputLadderDestination() {
        System.out.println(LADDER_GAME_RESULT_INPUT_MESSAGE);

        String gameResult = scanner.nextLine();
        return splitInputByDelimiter(gameResult);
    }

    public String inputPlayerWhoNeedsGameResult() {
        System.out.println(PLAYER_GAME_RESULT_MESSAGE);

        return scanner.nextLine();
    }
}
