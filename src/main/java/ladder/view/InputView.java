package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private static final Pattern NUMBER_REGEX = Pattern.compile("^-?[0-9]+$");

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public List<String> readNames() {
        System.out.println(InputMessage.INPUT_NAMES.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = new ArrayList<>(List.of(splitNames(input)));
        validateDuplicatedNames(names);
        return names;
    }

    private String[] splitNames(String input) {
        return input.split(",");
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_DUPLICATED_NAME.getMessage());
        }
    }

    public int readHeight() {
        System.out.println(InputMessage.INPUT_HEIGHT.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        validateHeight(input);
        return Integer.parseInt(input);
    }

    private void validateHeight(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_INTEGER.getMessage());
        }
    }

    private enum ErrorMessage {
        EXCEPTION_DUPLICATED_NAME("이름은 중복될 수 없습니다."),
        EXCEPTION_NOT_INTEGER("정수가 아닙니다.");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private enum InputMessage {

        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),

        INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?");
        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

}
