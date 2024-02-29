package ladder.view;

import ladder.exception.participant.DelimiterBoundaryException;
import ladder.exception.ladder.InvalidHeightNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NAME_DELIMITER = ",";
    private static final String REQUEST_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_OUTCOME = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String REQUEST_PARTICIPANT_OF_OUTCOME = "\n결과를 보고 싶은 사람은?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantsName() {
        System.out.println(REQUEST_PARTICIPANTS_NAME);
        final String names = scanner.nextLine();
        validateDelimiterPosition(names);
        return splitByDelimiter(names);
    }

    public List<String> readOutcomes() {
        System.out.println(REQUEST_OUTCOME);
        final String outcomes = scanner.nextLine();
        validateDelimiterPosition(outcomes);
        return splitByDelimiter(outcomes);
    }

    private void validateDelimiterPosition(final String input) {
        if (input.startsWith(NAME_DELIMITER) || input.endsWith(NAME_DELIMITER)) {
            throw new DelimiterBoundaryException();
        }
    }

    private List<String> splitByDelimiter(final String input) {
        return Arrays.stream(input.split(NAME_DELIMITER))
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
            throw new InvalidHeightNumberException();
        }
    }

    public String readRequiredOutcome() {
        System.out.println(REQUEST_PARTICIPANT_OF_OUTCOME);
        return scanner.nextLine();
    }
}
