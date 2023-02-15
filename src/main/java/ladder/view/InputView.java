package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.error.ErrorMessage;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String NUMERIC_FORMAT = "^[0-9]*$";

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> requestNames() {
        printMessage(Message.ASK_USER_NAMES);

        List<String> names = Arrays.asList(sc.nextLine().split(DELIMITER));
        validateNames(names);

        return names;
    }

    public static int requestLadderHeight() {
        printMessage(Message.ASK_LADDER_HEIGHT);

        String input = sc.nextLine();
        validateNumber(input);

        return Integer.parseInt(input);
    }

    private static void validateNames(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.getMessage());
        }
    }

    private static boolean hasDuplicateName(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private static void validateNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(NUMERIC_FORMAT);
    }

    private static void printMessage(Message message) {
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
