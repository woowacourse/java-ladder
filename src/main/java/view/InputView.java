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

    public List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputResults = scanner.nextLine();
        validateNotBlank(inputResults);

        return splitByCommaAndTrim(inputResults);
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = scanner.nextLine().trim();
        validateNotBlank(inputHeight);
        validateHeightIsInt(inputHeight);

        return Integer.parseInt(inputHeight);
    }

    public String readTargetPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        String inputTargetPlayer = scanner.nextLine().trim();
        validateNotBlank(inputTargetPlayer);

        return inputTargetPlayer;
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
