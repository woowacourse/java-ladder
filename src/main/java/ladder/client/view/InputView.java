package ladder.client.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_ITEMS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PLAYER_RESULT = "결과를 보고 싶은 사람은?";
    private static final String NOT_NUMBER_MESSAGE = "숫자만 입력 가능합니다. 현재 : %s";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputResultNames() {
        System.out.println(INPUT_RESULT_ITEMS);
        String resultItems = scanner.nextLine();
        return Arrays.stream(resultItems.split(",", -1))
                .collect(Collectors.toList());
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        String height = scanner.nextLine();
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER_MESSAGE, height));
        }
    }

    public String inputPlayerResult() {
        System.out.println(INPUT_PLAYER_RESULT);
        return scanner.nextLine();
    }

    public List<String> inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAMES);
        String playerNames = scanner.nextLine();
        return Arrays.stream(playerNames.split(",", -1))
                .collect(Collectors.toList());
    }
}
