package ladder.view;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private static final Pattern NUMBER_REGEX = Pattern.compile("^-?[0-9]+$");

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public List<String> readNames() {
        System.out.println(InputMessage.INPUT_NAMES.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = new ArrayList<>(List.of(input.split(",")));
        validateDuplicatedNames(names);
        return names;
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_DUPLICATED_NAME.getMessage());
        }
    }

    public List<String> readResults() {
        System.out.println(InputMessage.INPUT_RESULTS.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] results = input.replaceAll(" ", "").split(",");
        return new ArrayList<>(List.of(results));
    }

    public int readHeight() {
        System.out.println(InputMessage.INPUT_HEIGHT.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        validateHeight(input);
        validateBigHeight(input);
        return Integer.parseInt(input);
    }

    private void validateHeight(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_NOT_INTEGER.getMessage());
        }
    }

    private void validateBigHeight(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_BIG_HEIGHT.getMessage());
        }
    }

    public String readPlayerChoice() {
        System.out.println(InputMessage.INPUT_PLAYER_CHOICE.getMessage());

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private enum InputMessage {

        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
        INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
        INPUT_PLAYER_CHOICE("결과를 보고 싶은 사람은?");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

}
