package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputName = scanner.nextLine();
        validateNotBlank(inputName);

        return splitByCommaAndTrim(inputName);
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = scanner.nextLine().trim();
        validateNotBlank(inputHeight);
        validateHeightIsInt(inputHeight);

        return Integer.parseInt(inputHeight);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    private List<String> splitByCommaAndTrim(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toList();
    }

    private void validateHeightIsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("높이는 정수여야 합니다.");
        }
    }
}
