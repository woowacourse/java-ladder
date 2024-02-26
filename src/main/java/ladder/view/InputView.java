package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String REQUEST_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_GAME_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantsName() {
        System.out.println(REQUEST_PARTICIPANTS_NAME);
        final String names = scanner.nextLine();
        validateInputDelimiterPosition(names);
        return splitInput(names);
    }

    public List<String> readLadderGameResult() {
        System.out.println(REQUEST_LADDER_GAME_RESULT);
        final String ladderGameResult = scanner.nextLine();
        validateInputDelimiterPosition(ladderGameResult);
        return splitInput(ladderGameResult);
    }

    private void validateInputDelimiterPosition(final String input) {
        if (input.startsWith(INPUT_DELIMITER) || input.endsWith(INPUT_DELIMITER)) {
            throw new IllegalArgumentException("구분자는 양 끝에 입력할 수 없습니다.");
        }
    }

    private List<String> splitInput(final String input) {
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int readLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT);
        final String input = scanner.nextLine();
        return convertToHeight(input);
    }

    private int convertToHeight(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자로 입력해주세요.");
        }
    }

    public void closeResource() {
        scanner.close();
    }
}
