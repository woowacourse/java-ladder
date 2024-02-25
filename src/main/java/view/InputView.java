package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validatePlayers(input);
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validatePlayers(String input) {
        validateBlank(input);
        validateDoubleDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private void validateDoubleDelimiter(String input) {
        if (input.contains(DELIMITER.repeat(2))) {
            throw new IllegalArgumentException("올바른 형태로 구분자로 나뉘어 입력해주세요.");
        }
    }

    private void validateStartWord(String input) {
        if (input.startsWith(DELIMITER)) {
            throw new IllegalArgumentException("입력은 구분자로 시작할 수 없습니다.");
        }
    }

    private void validateEndWord(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("입력은 구분자로 끝날 수 없습니다.");
        }
    }

    public List<String> inputTargets() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateTargets(input);
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validateTargets(String input) {
        validateBlank(input);
        validateDoubleDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        validateHeight(input);
        return Integer.parseInt(input);
    }

    private void validateHeight(String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
    }

    private void validateNumeric(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("수로 입력해주세요.");
        }
    }

    private void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 범위의 수를 입력해주세요.");
        }
    }

    public List<String> inputResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        validateResult(input);
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validateResult(String input) {
        validateBlank(input);
    }
}
