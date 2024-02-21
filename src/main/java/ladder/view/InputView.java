package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String input = SCANNER.nextLine();

        validateInputBlank(input);
        return input;
    }

    public int readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final String input = SCANNER.nextLine();

        return parseToInt(input);
    }

    private void validateInputBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    private int parseToInt(final String input) {
        validateInputBlank(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }
}
