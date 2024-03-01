package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String WINNING_NAMES_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ITEMS_DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PERSON_NAME_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    public List<String> readPeopleNames() {
        System.out.println(PEOPLE_NAMES_INPUT_MESSAGE);
        String peopleNames = scanner.nextLine().strip();
        validateStartsOrEndsWithDelimiter(peopleNames);

        System.out.println();
        return splitByDelimiter(peopleNames);
    }

    public List<String> readWinningItems() {
        System.out.println(WINNING_NAMES_INPUT_MESSAGE);
        String winningResults = scanner.nextLine().strip();
        validateStartsOrEndsWithDelimiter(winningResults);

        System.out.println();
        return splitByDelimiter(winningResults);
    }

    private List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(ITEMS_DELIMITER))
                .map(String::strip)
                .toList();
    }

    private void validateStartsOrEndsWithDelimiter(String input) {
        if (input.startsWith(ITEMS_DELIMITER) || input.endsWith(ITEMS_DELIMITER)) {
            throw new IllegalArgumentException("입력은 콤마(,)로 시작하거나 끝날 수 없습니다.");
        }
    }

    public int readLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine().strip();

        System.out.println();
        return toInt(ladderHeight);
    }

    private int toInt(String ladderHeight) {
        try {
            return Integer.parseInt(ladderHeight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 숫자이어야 합니다.");
        }
    }

    public String readPersonNameForResult() {
        System.out.println(PERSON_NAME_INPUT_MESSAGE);

        return scanner.nextLine().strip();
    }
}
