package ladder.view.console;

import java.util.Scanner;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;
import ladder.view.InputView;

public class ConsoleInputView implements InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String input = SCANNER.nextLine();

        validateInputBlank(input);
        return input;
    }

    @Override
    public int readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final String input = SCANNER.nextLine();

        return parseToInt(input);
    }

    private void validateInputBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_BLANK);
        }
    }

    private int parseToInt(final String input) {
        validateInputBlank(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }
}
