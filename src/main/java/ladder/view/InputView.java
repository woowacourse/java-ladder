package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PEOPLE_NAMES_DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public List<String> readPeopleNames() {
        System.out.println(PEOPLE_NAMES_INPUT_MESSAGE);
        String peopleNames = scanner.nextLine().strip();
        validateStartsOrEndsWithDelimiter(peopleNames);

        System.out.println();
        return splitByDelimiter(peopleNames);
    }

    private List<String> splitByDelimiter(String peopleNames) {
        return Arrays.stream(peopleNames.split(PEOPLE_NAMES_DELIMITER))
                .map(String::strip)
                .toList();
    }

    private void validateStartsOrEndsWithDelimiter(String peopleNames) {
        if (peopleNames.startsWith(PEOPLE_NAMES_DELIMITER) || peopleNames.endsWith(PEOPLE_NAMES_DELIMITER)) {
            throw new IllegalArgumentException("사람들의 이름은 콤마(,)로 시작하거나 끝날 수 없습니다.");
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
}
