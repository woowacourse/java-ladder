package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ladder.constant.ErrorMessage.PEOPLE_NAMES_STARTS_OR_ENDS_WITH_DELIMITER;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PEOPLE_NAMES_DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    public static List<String> readPeopleNames() {
        OutputView.printMessage(PEOPLE_NAMES_INPUT_MESSAGE);
        String peopleNames = scanner.nextLine().strip();
        validateStartsOrEndsWithDelimiter(peopleNames);

        OutputView.printMessage("");
        return Arrays.stream(peopleNames.split(PEOPLE_NAMES_DELIMITER))
                .map(String::strip)
                .toList();
    }

    private static void validateStartsOrEndsWithDelimiter(String peopleNames) {
        if (peopleNames.startsWith(PEOPLE_NAMES_DELIMITER) || peopleNames.endsWith(PEOPLE_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(PEOPLE_NAMES_STARTS_OR_ENDS_WITH_DELIMITER.generate());
        }
    }

    public static String readLadderHeight() {
        OutputView.printMessage(LADDER_HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();

        OutputView.printMessage("");
        return ladderHeight;
    }
}
