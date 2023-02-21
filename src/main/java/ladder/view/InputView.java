package ladder.view;

import ladder.error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NUMERIC_FORMAT = "^-?[0-9]*$";
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestNames() {
        printMessage(Message.ASK_USER_NAMES);

        List<String> names = Arrays.asList(scanner.nextLine().split(DELIMITER));
        validateNames(names);

        return names;
    }

    private void validateNames(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.getMessage());
        }
    }

    private boolean hasDuplicateName(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }


    public int requestLadderHeight() {
        printMessage(Message.ASK_LADDER_HEIGHT);

        String input = scanner.nextLine();
        validateIsNumeric(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_HEIGHT_RANGE.getMessage());
        }
    }

    private void validateIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMERIC_FORMAT);
    }

    private void printMessage(Message message) {
        System.out.println(message.value);
    }

    private enum Message {
        ASK_USER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        ASK_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?");

        private final String value;

        Message(String value) {
            this.value = value;
        }
    }
}
