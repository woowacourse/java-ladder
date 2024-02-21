package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();

        validateInputBlank(input);
        return input;
    }

    private void validateInputBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }
}
