package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputNameOfParticipants() {
        String names = scanner.nextLine();

        validateBlank(names);
        validateDelimiter(names);

        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDelimiter(String names) {
        if (!names.contains(DELIMITER)) {
            throw new IllegalArgumentException("1 이상의 요소가 저장되어 있는 이름 목록을 입력해주세요.");
        }
    }

    public List<String> inputLadderResults() {
        String inputResult = scanner.nextLine();

        validateBlank(inputResult);
        validateDelimiter(inputResult);

        return Arrays.stream(inputResult.split(DELIMITER))
            .collect(Collectors.toUnmodifiableList());
    }

    public int inputHeightOfLadder() {
        String inputHeight = scanner.nextLine();

        validateBlank(inputHeight);
        return mapToHeightNumber(inputHeight);
    }

    private int mapToHeightNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식을 입력해주세요.");
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }
}
