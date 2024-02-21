package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private  final Scanner scanner = new Scanner(System.in);

    public List<String> readUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateInput(input);
        return Arrays.stream(input.split(","))
                .toList();
    }

    public int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return convertInteger(input);

    }

    private void validateInput(String input) {
        if (input.isEmpty() || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private int convertInteger(String input) {
        int value = parseInt(input);
        validatePositive(value);
        return value;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 최대 사다리 높이는 숫자만 가능합니다.");
        }
    }

    private void validatePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("[ERROR] 최대 사다리 높이는 양의 정수여야 합니다.");
        }
    }

}
