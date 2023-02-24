package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPLIT_STANDARD = ",";
    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView getInstance(Scanner scanner) {
        return new InputView(scanner);
    }

    public List<String> readNames() {
        return splitByComma(readInput(Message.INPUT_NAMES.message));
    }

    public List<String> readMissions() {
        return splitByComma(readInput(Message.INPUT_MISSIONS.message));
    }

    public int readHeight() {
        String input = readInput(Message.INPUT_LADDER_SIZE.message);
        return parseHeight(input);
    }

    public String readSearchCommand() {
        return readInput(Message.INPUT_PLAYER_FOR_RESULT.message);
    }

    private String readInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private List<String> splitByComma(String input) {
        return Arrays.stream(input.split(SPLIT_STANDARD)).collect(Collectors.toList());
    }

    private static int parseHeight(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.EXCEPTION_INVALID_HEIGHT.message);
        }

    }

    private enum Message {
        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_MISSIONS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
        INPUT_LADDER_SIZE("최대 사다리 높이는 몇 개인가요?"),
        INPUT_PLAYER_FOR_RESULT("결과를 보고 싶은 사람은? (전체 보기: all, 그만 보기: enter)"),
        EXCEPTION_INVALID_HEIGHT("int 범위 내의 숫자만 입력 가능합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
